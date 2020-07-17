package com.imooc.weixin.service.impl;

import com.imooc.weixin.dataobject.ProductInfo;
import com.imooc.weixin.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productService;

    @Test
    void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception{
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("汉堡");
        productInfo.setProductPrice(new BigDecimal(33.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("老八蜜汁小憨包");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(88);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale()
    {
        ProductInfo result = productService.onSale("123456");

        Assert.assertEquals(ProductStatusEnum.UP,result.getProductStatusEnum());
    }

    @Test
    public void offSale()
    {
        ProductInfo result = productService.offSale("123456");

        Assert.assertEquals(ProductStatusEnum.DOWN,result.getProductStatusEnum());
    }
}