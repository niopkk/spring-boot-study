package com.bbz.简单工厂;

/**
 * com.bbz.简单工厂
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class VehicleFactory {

    private VehicleFactory() {

    }

    public static IVehicle getVehicle(String type) {
        if ("car".equals(type)) {
            return new Car();
        } else if ("motorcycle".equals(type)) {
            return new Motorcycle();
        }

        throw new IllegalArgumentException("请输入工具类型");
    }
}
