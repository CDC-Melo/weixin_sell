package com.imooc.weixin.service.impl;

import com.imooc.weixin.dataobject.SellerInfo;
import com.imooc.weixin.repository.SellerInfoRepository;
import com.imooc.weixin.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService
{

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid)
    {
        return repository.findByOpenid(openid);
    }
}
