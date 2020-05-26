package com.bbz.代理模式.静态代理案例;

import com.bbz.代理模式.静态代理案例.model.Order;
import com.bbz.代理模式.静态代理案例.server.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService{

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }


    public int createOrder(Order order) {
      before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配【db_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("Proxy before method.");
    }

    private void after() {
        System.out.println("Proxy after method.");
    }
}
