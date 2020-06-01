package com.bbz.装饰者模式;

public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void doSometing() {

    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+一根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 5;
    }
}
