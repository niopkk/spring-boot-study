package com.bbz.service.impl;

import com.bbz.dao.ProductOrderDao;
import com.bbz.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements com.bbz.service.ProductOrderService {

    @Autowired
    private ProductOrderDao productOrderDao;

    @Override
    public Integer insert(ProductOrder productOrder) {

        return productOrderDao.insert(productOrder);

    }
}
