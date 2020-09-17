package com.bbz.dao;

import com.bbz.model.Order;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderMapper {


    boolean createOrder(Order order);

}
