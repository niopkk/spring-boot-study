package com.bbz.repository;

import com.bbz.model.Order;
import com.bbz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, String> {


    Order findById(int id);


    @Query(value = "update orders set version=version+1,stock=stock-1 where version=?1 and id=?2", nativeQuery = true)
    boolean update(int id, int version);
}
