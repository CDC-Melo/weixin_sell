package com.imooc.weixin.repository;

import com.imooc.weixin.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>
{
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);

    OrderMaster findByOrderId(String orderId);
}
