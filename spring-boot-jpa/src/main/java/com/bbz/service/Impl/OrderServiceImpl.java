package com.bbz.service.Impl;

import com.bbz.model.Order;
import com.bbz.repository.OrderRepository;
import com.bbz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean update(int id, int version) {
        return false;
    }
}
