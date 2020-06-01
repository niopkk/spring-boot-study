package com.bbz.装饰者模式;

public class MainTest {

    public static void main(String[] args) {
        Battercake battercake;
        battercake = new BaseBatercake();
        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);


        System.out.println(battercake.getMsg() + ",总价:" + battercake.getPrice());
    }
}
