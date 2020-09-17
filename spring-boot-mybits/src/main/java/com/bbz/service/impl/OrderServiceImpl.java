package com.bbz.service.impl;

import com.bbz.dao.OrderMapper;
import com.bbz.dao.ProductMapper;
import com.bbz.model.Order;
import com.bbz.model.Product;
import com.bbz.service.OrderServer;
import com.bbz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderServer {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductService productService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean createOrder(Order order) throws Exception {
        final Product product = productService.findProductById(1);
        if (product.getStock() > 0) {
            boolean isCreate = orderMapper.createOrder(order);
            final boolean stock = productService.updateStock(1, product.getVersion());
            if (!stock) {
                throw new Exception("下单失败，库存不足");
            }

        }
        return false;
    }
}
