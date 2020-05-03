package com.example.demo.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.IPinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [根据IP获取对应的详细信息]
 *
 * @author :  ws
 * Create at:  2020/4/23 12:08
 * Copyright: 沈阳峰行科技版权所有
 * @version : 1.0
 */
public class GetIPDetails {
    private static final Logger logger = LoggerFactory.getLogger(GetIPDetails.class);

    public static  List<IPinfo> myIps = new ArrayList<IPinfo>();
    public static  List<IPinfo> myProvinces = new ArrayList<IPinfo>();
    {
        if(myProvinces==null||myProvinces.size()==0){
            try{
                myProvinces = (List<IPinfo>) JSONObject.parseArray(getJson("ip_province_info.json"),IPinfo.class);
            }catch (Exception e){
                e.printStackTrace();
                myProvinces = null;
            }
        }

        if(myIps==null||myIps.size()==0){
            try{
                myIps = (List<IPinfo>)  JSONObject.parseArray(getJson("ip_info.json"),IPinfo.class);
            }catch (Exception e){
                e.printStackTrace();
                myIps = myProvinces;
            }
        }


    }

    /**
     * 根据IP获取对应的详细信息
     * @param ip
     * @return
     */
    public static String getIpCode(String ip,String type){
        if(!type.equals("1")){
            myIps = myProvinces;
        }
        if(myIps==null||myIps.size()==0) return null;
        long iplong= IPUtils.ipToLong(ip);
        if(iplong<myIps.get(0).getStartip()||iplong>myIps.get(myIps.size()-1).getEndip()) return null;
        int left=0;
        int right=myIps.size()-1;
        int mid=(left+right)/2;
        while (left<=right){
            if(iplong< myIps.get(mid).getStartip()) right=mid-1;
            if(iplong> myIps.get(mid).getStartip()) left=mid+1;
            if(iplong>=myIps.get(mid).getStartip()&&iplong<=myIps.get(mid).getEndip()){
                IPinfo ipinfo =  myIps.get(mid);
                String ipjson = JSON.toJSONString(ipinfo);
                return ipjson;
            }
            mid=(left+right)/2;
        }
        return null;
    }

    /**
     * 获取static中的ip_json中的数据并转为json格式
     * @return
     */
    public  String getJson(String fileName) throws IOException {
        String filePath = GetIPDetails.class.getClassLoader().getResource("").getPath()+"static/"+fileName;
        logger.info("获取josn路径"+filePath);
        // String filePath = "/ip_info.json";
        String jsonStr = "";
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file),"Utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        //获取开始时间
        long startTime=System.currentTimeMillis();
        GetIPDetails getds = new GetIPDetails();
        String code= GetIPDetails.getIpCode("222.88.241.106","1");
        //获取结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        System.out.println("你所在的城市为："+code);
    }
}
