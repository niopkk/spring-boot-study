package com.bbz.策略模式.案例.pay;

public class AliPay extends Payment {
    @Override
    public String getPayName() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 900;
    }
}
