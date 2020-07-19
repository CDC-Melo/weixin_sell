package com.imooc.weixin.service;

import com.imooc.weixin.dto.OrderDTO;

/**
 * 推送消息
 */
public interface PushMessage
{
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
