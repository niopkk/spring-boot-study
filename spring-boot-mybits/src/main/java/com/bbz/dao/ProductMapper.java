package com.bbz.dao;

import com.bbz.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

    Product findProductById(Integer id);


    boolean updateStock(@Param(value = "id") Integer id, @Param(value = "version") Integer version);
}
