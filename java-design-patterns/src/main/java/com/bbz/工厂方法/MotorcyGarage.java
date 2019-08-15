package com.bbz.工厂方法;

/**
 * com.bbz.工厂方法
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MotorcyGarage implements IVehicleGarage {
    @Override
    public IVehicle getVehicle() {
        return new Motorcycle();
    }
}
