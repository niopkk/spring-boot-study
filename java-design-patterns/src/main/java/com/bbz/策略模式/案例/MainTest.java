package com.bbz.策略模式.案例;

import com.bbz.策略模式.案例.pay.PayStrategy;

public class MainTest {

    public static void main(String[] args) {



        Order order = new Order("111", "00000001", 20);
        order.pay(PayStrategy.UNION_PAY);
    }
}
