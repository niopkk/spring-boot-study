package com.bbz.代理模式.静态代理案例.dao;

import com.bbz.代理模式.静态代理案例.model.Order;

public class OrderDao {
    public int insert(Order order) {
        System.out.println("订单创建成功!");
        return 1;
    }
}
