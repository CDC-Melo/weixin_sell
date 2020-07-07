package com.imooc.weixin.service.impl;

import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.service.OrderService;
import com.imooc.weixin.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class PayServiceImplTest
{
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    void create()
    {
        OrderDTO orderDTO = orderService.findOne("1593503741052246173");
        payService.create(orderDTO);
    }

    @Test
    public void refund()
    {
        OrderDTO orderDTO = orderService.findOne("1593503741052246173");
        payService.refund(orderDTO);
    }
}