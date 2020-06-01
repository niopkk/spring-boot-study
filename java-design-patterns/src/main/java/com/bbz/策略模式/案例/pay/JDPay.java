package com.bbz.策略模式.案例.pay;

public class JDPay extends Payment {
    @Override
    public String getPayName() {
        return "京东";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}
