package com.imooc.weixin.controller;

/*
卖家端商品
* */

import com.imooc.weixin.dataobject.ProductCategory;
import com.imooc.weixin.dataobject.ProductInfo;
import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.exception.SellException;
import com.imooc.weixin.service.CategoryService;
import com.imooc.weixin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController
{

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object> map)
    {
        PageRequest request = PageRequest.of(page - 1,size);

        Page<ProductInfo> productInfoPage =  productService.findAll(request);

        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map)
    {
        try
        {
            productService.onSale(productId);
        }
        catch (SellException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");

            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map)
    {
        try
        {
            productService.offSale(productId);
        }
        catch (SellException e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");

            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                      Map<String, Object> map)
    {
        if(!StringUtils.isEmpty(productId))
        {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("product/index",map);
    }
}
