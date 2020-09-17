package com.bbz.service;

import com.bbz.model.Order;

public interface OrderServer {

    boolean createOrder(Order order) throws Exception;
}
