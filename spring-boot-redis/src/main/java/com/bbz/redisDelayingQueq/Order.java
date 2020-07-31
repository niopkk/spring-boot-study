package com.bbz.redisDelayingQueq;

public class Order {


    private String name;

    private String orderNo;

    private String state;



    public Order() {

    }

    public Order(Integer id, String name, String orderNo, String state) {

        this.name = name;
        this.orderNo = orderNo;
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
