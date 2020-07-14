package com.bbz.dao;

import com.bbz.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderItemDao {

    void insert(OrderItem orderItem);


}
