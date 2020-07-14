package com.bbz.service.impl;

import com.bbz.dao.OrderItemDao;
import com.bbz.model.OrderItem;
import com.bbz.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }
}
