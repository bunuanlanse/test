package com.example.demo.controller;
import com.example.demo.Util.GetIPDetails;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping(value = "/api")
public class FindIpInfoController {
    private static final Logger logger = LoggerFactory.getLogger(GetIPDetails.class);
    /**
     *根据ip查询ip详情
     * @param ip ,type(非必传，1-查市一级，2-查省一级)
     * @return
     */
    @RequestMapping(value = "/findIpInfo")
    public String findIpInfo(@RequestParam(value = "ip") String ip,@RequestParam(defaultValue = "1",required = false)String type){

        logger.info("获取传入的ip值:" + ip);
        //获取开始时间
        long startTime=System.currentTimeMillis();
        String ipDetails= GetIPDetails.getIpCode(ip,type);
        //获取结束时间
        long endTime=System.currentTimeMillis();
        logger.info("程序运行时间: "+(endTime-startTime)+"ms");
        logger.info("返回的参数:" + ipDetails);
        return ipDetails;
    };

}
