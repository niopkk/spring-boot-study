package com.bbz.策略模式.案例;

import com.bbz.策略模式.案例.pay.PayState;
import com.bbz.策略模式.案例.pay.PayStrategy;
import com.bbz.策略模式.案例.pay.Payment;

public class Order {

    private String uid;

    private String orderId;

    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getPayName());
        System.out.println("本次交易金额为" + amount + ",开始扣款");
        return payment.pay(uid, amount);
    }
}
