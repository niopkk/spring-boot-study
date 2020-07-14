package com.bbz.controller;

import com.bbz.model.ProductOrder;
import com.bbz.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductOrderController {


    @Autowired
    private ProductOrderService productOrderService;


    @RequestMapping("/save")
    @ResponseBody
    public String save() {

        ProductOrder productOrder = new ProductOrder();
        productOrder.setName("测试订单00000000006");
        productOrder.setOrderNo("202007011000000006");
        productOrder.setTotalPrice(22200L);
        productOrder.setPayType(1);
        productOrder.setCreateTime(System.currentTimeMillis());

        productOrderService.insert(productOrder);
        return productOrder.getId().toString();
    }
}
