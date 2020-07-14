package com.bbz.model;


import lombok.Data;

@Data
public class OrderItem {

    private Integer id;

    private Integer orderId;

    private Long unitPrice;

    private Long createTime;
}
