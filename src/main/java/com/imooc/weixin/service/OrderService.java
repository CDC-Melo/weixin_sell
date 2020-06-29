package com.imooc.weixin.service;

import com.imooc.weixin.dataobject.OrderMaster;
import com.imooc.weixin.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个
    OrderDTO findOne(String orderId);

    //查询列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);
}