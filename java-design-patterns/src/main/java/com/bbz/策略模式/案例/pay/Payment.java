package com.bbz.策略模式.案例.pay;

public abstract class Payment {

    /**
     * 支付类型
     *
     * @return
     */
    public abstract String getPayName();

    /**
     * 查询余额
     */
    public abstract double queryBalance(String uid);


    /**
     * 扣款支付
     *
     * @param uid
     * @param amount
     * @return
     */
    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败", "余额不足");
        }
        return new PayState(100, "支付成功", "支付金额" + amount);
    }
}
