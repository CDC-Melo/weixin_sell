package com.imooc.weixin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController
{
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code)
    {
        log.info("auth");
        log.info("code={}",code);

        String url = "";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);

        log.info("response={}",response);
    }
}
