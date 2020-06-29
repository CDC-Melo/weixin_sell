package com.imooc.weixin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Slf4j
public class LoggerTest
{
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1()
    {
        String name = "imooc";
        String password = "123456";
        logger.debug("debug....");
        //logger.info("info....");
        logger.info("name: {}, password: {}", name,password);
        logger.error("error....");
        logger.warn("warning...");
    }
}
