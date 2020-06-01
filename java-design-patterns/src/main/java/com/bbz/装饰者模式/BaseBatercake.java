package com.bbz.装饰者模式;

public class BaseBatercake extends Battercake {
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
