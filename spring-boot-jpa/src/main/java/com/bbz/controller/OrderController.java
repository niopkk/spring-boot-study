package com.bbz.controller;

import com.bbz.model.Order;
import com.bbz.service.OrderService;
import com.bbz.util.Jsons;
import com.bbz.util.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> save(Order order) {

        final Order save = orderService.save(order);
        order.setPort(serverPort);
        return Maps.of("result", "保存成功！");
    }


    @RequestMapping(value = "/stock/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> stock(@PathVariable("id") int id) {
        final Order order = orderService.findById(id);
        if (order.getStock() > 0) {
//            order.setVersion(order.getVersion() + 1);
//            order.setPort(serverPort);
            order.setStock(order.getStock() - 1);
            order.setUpdateTime(System.currentTimeMillis());
            orderService.save(order);
        }
        return Maps.of("result", "更新成功！" + serverPort);
    }

}
