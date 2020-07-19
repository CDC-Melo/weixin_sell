package com.imooc.weixin.service.impl;

import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.service.PushMessage;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushMessageImpl implements PushMessage
{
    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO)
    {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();

        try
        {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
        }
    }
}
