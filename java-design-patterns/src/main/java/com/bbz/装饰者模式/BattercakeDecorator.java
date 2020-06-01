package com.bbz.装饰者模式;

public abstract class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSometing();

    @Override
    public String getMsg() {
        return battercake.getMsg();
    }

    @Override
    public int getPrice() {
        return battercake.getPrice();
    }
}
