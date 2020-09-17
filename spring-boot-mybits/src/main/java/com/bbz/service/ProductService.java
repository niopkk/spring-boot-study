package com.bbz.service;

import com.bbz.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductService {


    Product findProductById(int id);


    boolean updateStock(int id, int version);
}
