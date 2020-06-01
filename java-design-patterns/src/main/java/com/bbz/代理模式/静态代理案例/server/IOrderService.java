package com.bbz.代理模式.静态代理案例.server;

import com.bbz.代理模式.静态代理案例.model.Order;

public interface IOrderService {

    int createOrder(Order order);
}
