package com.imooc.weixin.service.impl;

import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PushMessageServiceImplTest
{

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus()
    {
        OrderDTO orderDTO = orderService.findOne("1593434728011321454");

        pushMessageService.orderStatus(orderDTO);
    }
}