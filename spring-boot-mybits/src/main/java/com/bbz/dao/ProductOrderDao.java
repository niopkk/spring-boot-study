package com.bbz.dao;

import com.bbz.model.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductOrderDao {

    Integer insert(ProductOrder productOrder);
}
