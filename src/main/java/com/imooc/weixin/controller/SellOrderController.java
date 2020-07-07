package com.imooc.weixin.controller;

import com.imooc.weixin.dto.OrderDTO;
import com.imooc.weixin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/order")
public class SellOrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object> map)
    {
        PageRequest request = PageRequest.of(page - 1,size);

        Page<OrderDTO> orderDTOPage = orderService.findList(request);

        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        return new ModelAndView("order/list",map);
    }
}
