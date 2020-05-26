package com.bbz.代理模式.静态代理案例;

import com.bbz.代理模式.静态代理案例.model.Order;
import com.bbz.代理模式.静态代理案例.server.IOrderService;
import com.bbz.代理模式.静态代理案例.server.impl.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

    public static void main(String[] args) {
        try {
            Order order=new Order();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
            Date date=sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());
            IOrderService orderService=new OrderServiceStaticProxy(new OrderServiceImpl());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
