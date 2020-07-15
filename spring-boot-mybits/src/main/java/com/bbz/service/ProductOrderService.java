package com.bbz.service;

import com.bbz.model.ProductOrder;

import java.util.List;

public interface ProductOrderService {

    Integer insert(ProductOrder productOrder);

    ProductOrder findProductByIdAndName(int id, String name);

    boolean updateProductOrder(ProductOrder productOrder);

    boolean deleteById(int id);


    boolean batchDeleteIds(List<String> ids);
}
