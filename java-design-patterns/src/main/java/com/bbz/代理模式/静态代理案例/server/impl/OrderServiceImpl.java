package com.bbz.代理模式.静态代理案例.server.impl;

import com.bbz.代理模式.静态代理案例.dao.OrderDao;
import com.bbz.代理模式.静态代理案例.model.Order;
import com.bbz.代理模式.静态代理案例.server.IOrderService;

public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("orderService调用成功!");
        return orderDao.insert(order);
    }
}
