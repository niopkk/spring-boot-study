package com.bbz.producer.controller;

import com.bbz.core.entity.Order;
import com.bbz.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public Boolean saveOrder() {

        Order order = new Order();
        order.setId("20190227000001675");
        order.setMessageId(UUID.randomUUID().toString() + System.currentTimeMillis());
        order.setName(UUID.randomUUID().toString());
        orderService.createOrder(order);
        return Boolean.TRUE;
    }
}
