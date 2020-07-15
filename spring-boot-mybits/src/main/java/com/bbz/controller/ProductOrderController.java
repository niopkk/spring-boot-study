package com.bbz.controller;

import com.bbz.model.ProductOrder;
import com.bbz.service.ProductOrderService;
import com.bbz.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/getProductOrder")
    @ResponseBody
    public ProductOrder getProductOrder() {


        return productOrderService.findProductByIdAndName(3, "测试订单00000000003");

    }

    @RequestMapping("/getProductOrders")
    @ResponseBody
    public List<ProductOrder> getProductOrders() {


        return productOrderService.findProducts();

    }

    @RequestMapping("/updateProductOrder")
    @ResponseBody
    public Boolean updateProductOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setId(1);
        productOrder.setName("测试订单00000000009");
        productOrder.setOrderNo("202007011000000009");
        productOrder.setTotalPrice(23200L);
        productOrder.setPayType(4);
        return productOrderService.updateProductOrder(productOrder);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Boolean deleteProductOrder(@PathVariable("id") Integer id) {

        return productOrderService.deleteById(id);
    }

    @RequestMapping("/deletes")
    @ResponseBody
    public Boolean deleteProductOrders() {

        return productOrderService.batchDeleteIds(Lists.of("2", "6"));
    }


}
