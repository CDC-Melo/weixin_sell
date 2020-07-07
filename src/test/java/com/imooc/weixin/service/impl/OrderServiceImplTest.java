package com.imooc.weixin.service.impl;

import com.imooc.weixin.dataobject.OrderDetail;
import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.enums.OrderStatusEnum;
import com.imooc.weixin.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1593434491657592077";

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);


    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("郫县");
        orderDTO.setBuyerName("爹");
        orderDTO.setBuyerPhone("17610832119");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        logger.info("[创建订单] result={}",result);

        Assert.assertNotNull(result);
    }

    @Test
    void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);

        logger.info("[查询单个订单] result={}",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    void findList() {

        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.cancel(orderDTO);

        Assert.assertEquals(OrderStatusEnum.CANCELED.getCode(),result.getOrderStatus());
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.finish(orderDTO);

        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);

        OrderDTO result = orderService.paid(orderDTO);

        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}