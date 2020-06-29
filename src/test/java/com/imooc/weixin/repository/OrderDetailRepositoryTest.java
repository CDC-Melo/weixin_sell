package com.imooc.weixin.repository;

import com.imooc.weixin.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest()
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123459");
        orderDetail.setOrderId("11111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1212");
        orderDetail.setProductName("大米");
        orderDetail.setProductPrice(new BigDecimal(2.3));
        orderDetail.setProductQuantity(1);

        OrderDetail result = repository.save(orderDetail);

        Assert.assertNotNull(result);
    }

    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111");
        Assert.assertEquals(0,orderDetailList.size());
    }
}