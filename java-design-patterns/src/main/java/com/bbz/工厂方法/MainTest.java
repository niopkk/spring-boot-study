package com.bbz.工厂方法;

/**
 * com.bbz.工厂方法
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        IVehicleGarage vehicleGarage = new CarGarAge();
        vehicleGarage.getVehicle().run();


    }
}
