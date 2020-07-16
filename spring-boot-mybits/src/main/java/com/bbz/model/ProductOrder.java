package com.bbz.model;

import lombok.Data;

@Data
public class ProductOrder {

    private Integer  id;

    private String name;

    private String orderNo;

    private Long totalPrice;

    private Integer payType;

    private Long createTime;

    private String sort;
}
