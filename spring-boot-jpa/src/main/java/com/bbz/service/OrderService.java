package com.bbz.service;

import com.bbz.model.Order;

public interface OrderService {

    Order save(Order order);


    Order findById(int id);


    boolean update(int id,int version);
}
