package com.bbz.工厂.工厂方法;

/**
 * com.bbz.工厂.工厂方法
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class CarFactory implements IVehicleFactory {

    @Override
    public IVehicle create() {
        return new Car();
    }
}
