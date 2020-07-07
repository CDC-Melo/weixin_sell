package com.imooc.weixin.service;


import com.imooc.weixin.dto.OrderDTO;

public interface PayService
{
    void create(OrderDTO orderDTO);
}
