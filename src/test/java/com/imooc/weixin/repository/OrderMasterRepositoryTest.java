package com.imooc.weixin.repository;

import com.imooc.weixin.dataobject.OrderMaster;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "111";

    @Test
    public void saveTest()
    {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("12345678");
        orderMaster.setBuyerAddress("成都");
        orderMaster.setBuyerOpenid("111");
        orderMaster.setOrderAmount(new BigDecimal(12.6));

        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);
    }

    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);

        Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());
    }
}