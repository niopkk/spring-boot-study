package com.bbz.controller;


import com.bbz.model.Order;
import com.bbz.service.OrderServer;
import com.bbz.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderServer orderServer;

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/creareOrder", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> createOrder() {
        Order order = new Order();
        order.setUpdateTime(System.currentTimeMillis());
        order.setPorts(serverPort);
        try {
            orderServer.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Maps.of("result", "更新成功！" + serverPort);
    }
}
