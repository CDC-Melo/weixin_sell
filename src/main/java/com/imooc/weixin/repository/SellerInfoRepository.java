package com.imooc.weixin.repository;

import com.imooc.weixin.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>
{
    SellerInfo findByOpenid(String openid);
}
