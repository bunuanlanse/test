package com.example.demo.controller;


import com.example.demo.Util.GetIPDetails;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * [给涛哥转换数据]
 *
 * @author :  DAKANG
 * Create at:  2020/4/23 18:56
 * Copyright: 沈阳峰行科技版权所有
 * @version : 1.0
 */
@Log
@RestController
@RequestMapping(value = "/api")
public class ExchangeParamController {

    private static final Logger logger = LoggerFactory.getLogger(GetIPDetails.class);
    @RequestMapping(value = "/exchange")
    public String findIpInfo(@RequestParam(value = "xmip") String xmip){
        logger.info("获取传入的ip值:" + xmip);
        String  requestPathUrl = "http://cpm.adtmm.com/taskmanage/nownum.aspx?xmid="+xmip;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(requestPathUrl,String.class);
        logger.info("返回的参数:" + result);
        return result.getBody();
    };

    public static void main(String[] args) {
        String  requestPathUrl = "http://cpm.adtmm.com/taskmanage/nownum.aspx?xmid=23068";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(requestPathUrl,String.class);
        System.out.println( result.getBody());
    }
}
