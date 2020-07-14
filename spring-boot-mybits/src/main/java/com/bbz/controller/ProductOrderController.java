package com.bbz.controller;

import com.bbz.model.ProductOrder;
import com.bbz.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductOrderController {


    @Autowired
    private ProductOrderService productOrderService;


    @RequestMapping("/save")
    public void save() {

        ProductOrder productOrder = new ProductOrder();
        productOrder.setName("测试订单00000000001");
        productOrder.setOrderNo("202007011000000001");
        productOrder.setPayType(1);
        productOrder.setCreateTime(System.currentTimeMillis());

        Integer insert = productOrderService.insert(productOrder);
        System.out.println(insert);
    }
}
