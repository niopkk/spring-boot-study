package com.bbz.策略模式.案例.pay;

public class WechatPay extends Payment {
    @Override
    public String getPayName() {
        return "微信";
    }

    @Override
    public double queryBalance(String uid) {
        return 256;
    }
}
