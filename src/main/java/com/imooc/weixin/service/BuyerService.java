package com.imooc.weixin.service;


import com.imooc.weixin.dto.OrderDTO;

//买家
public interface BuyerService
{

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
