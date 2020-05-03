package com.example.demo.serve;

import com.example.demo.Util.GetIPDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * [项目启动预加载]
 *
 * @author :  ws
 * Create at:  2020/4/23 15:13
 * Copyright: 沈阳峰行科技版权所有
 * @version : 1.0
 */

@Service
public class InitIPDetails implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(InitIPDetails.class);
    @Override
    public void afterPropertiesSet() throws Exception {
        //需求初始化的方法
        GetIPDetails g = new GetIPDetails();
        logger.info("InitializingBean:加载IP详情到内存中");
    }
}
