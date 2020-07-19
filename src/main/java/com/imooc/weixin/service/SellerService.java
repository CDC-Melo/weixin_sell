package com.imooc.weixin.service;

import com.imooc.weixin.dataobject.SellerInfo;

public interface SellerService
{
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
