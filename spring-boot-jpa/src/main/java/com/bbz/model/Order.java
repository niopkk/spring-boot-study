package com.bbz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private int status;

    @Column(name = "version")
    private int version;

    @Column(name = "ports")
    private String port;

    @Column(name = "update_time")
    private long updateTime;

    @Column(name = "stock")
    private int stock;
}
