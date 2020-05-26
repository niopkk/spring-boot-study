package com.bbz.工厂.简单工厂;

/**
 * com.bbz.工厂.简单工厂
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class Car implements IVehicle {
    @Override
    public void run() {
        System.out.println("开汽车.....");
    }
}
