package com.bbz.model;

import lombok.Data;


@Data
public class Order {

    private int id;

    private int status;

    private String ports;

    private long updateTime;

}
