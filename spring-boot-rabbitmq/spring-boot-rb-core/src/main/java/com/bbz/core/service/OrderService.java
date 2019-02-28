package com.bbz.core.service;


import com.bbz.core.entity.Order;

public interface OrderService {

    /**
     * 下单
     * @param order
     * @return
     */
    void createOrder(Order order);
}
