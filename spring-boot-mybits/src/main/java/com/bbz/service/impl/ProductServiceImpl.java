package com.bbz.service.impl;

import com.bbz.dao.ProductMapper;
import com.bbz.model.Product;
import com.bbz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findProductById(int id) {
        return productMapper.findProductById(id);
    }

    @Override
    public boolean updateStock(int id, int version) {
        return productMapper.updateStock(id, version);
    }
}
