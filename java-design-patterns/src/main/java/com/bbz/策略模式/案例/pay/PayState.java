package com.bbz.策略模式.案例.pay;

public class PayState {

    public PayState(Integer code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    private Integer code;

    private Object data;

    private String msg;

    @Override
    public String toString() {
        return ("支付状态:[" + code + "]," + msg + ",交易详情" + data);
    }

    //    SUCCESS(100, "支付成功"),
//    FAIL(500, "支付失败,余额不足");
//
//    PayState(Integer code, String message) {
//        this.code = code;
//        this.message = message;
//    }
//
//    private Integer code;
//
//    private String message;

}
