package com.bbz.简单工厂;

/**
 * com.bbz.简单工厂
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        IVehicle car = VehicleFactory.getVehicle("car");
        car.run();

        IVehicle motorcycle = VehicleFactory.getVehicle("motorcycle");
        motorcycle.run();


    }
}
