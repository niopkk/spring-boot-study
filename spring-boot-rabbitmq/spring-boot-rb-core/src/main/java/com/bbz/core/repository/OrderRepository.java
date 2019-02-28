package com.bbz.core.repository;

import com.bbz.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order>, Serializable {

}
