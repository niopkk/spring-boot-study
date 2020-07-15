package com.bbz.service.impl;

import com.bbz.dao.ProductOrderDao;
import com.bbz.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements com.bbz.service.ProductOrderService {

    @Autowired
    private ProductOrderDao productOrderDao;

    @Override
    public Integer insert(ProductOrder productOrder) {

        return productOrderDao.insert(productOrder);

    }

    @Override
    public List<ProductOrder> findProducts() {
        return productOrderDao.findProducts();
    }

    @Override
    public ProductOrder findProductByIdAndName(int id, String name) {
        return productOrderDao.findProductByIdAndName(id, name);
    }

    @Override
    public boolean updateProductOrder(ProductOrder productOrder) {
        return productOrderDao.updateProductOrder(productOrder);
    }

    @Override
    public boolean deleteById(int id) {
        return productOrderDao.deleteById(id);
    }

    @Override
    public boolean batchDeleteIds(List<String> ids) {
        return productOrderDao.batchDeleteIds(ids);
    }
}
