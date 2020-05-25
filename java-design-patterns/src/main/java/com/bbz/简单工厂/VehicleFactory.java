package com.bbz.简单工厂;

/**
 * com.bbz.简单工厂
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class VehicleFactory {

    private VehicleFactory() {

    }

    public static IVehicle create(Class<? extends IVehicle> classz) {
        try {
            if (null != classz) {
                return classz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
