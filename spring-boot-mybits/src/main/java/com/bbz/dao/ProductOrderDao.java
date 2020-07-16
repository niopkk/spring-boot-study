package com.bbz.dao;

import com.bbz.model.ProductOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOrderDao {

    Integer insert(ProductOrder productOrder);


    List<ProductOrder> findProductOrder(ProductOrder productOrder);

    List<ProductOrder> findProducts();


    ProductOrder findProductByIdAndName(@Param("id") int id, @Param("name") String name);


    boolean updateProductOrder(ProductOrder productOrder);


    boolean deleteById(int id);

    boolean batchDeleteIds(@Param("ids") List<String> ids);

}
