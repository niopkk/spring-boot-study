package com.bbz.策略模式.案例.pay;

public class UnionPay extends Payment {
    @Override
    public String getPayName() {
        return "银联";
    }

    @Override
    public double queryBalance(String uid) {
        return 120;
    }
}
