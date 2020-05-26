package com.bbz.工厂.简单工厂;

/**
 * com.bbz.工厂.简单工厂
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        IVehicle car = VehicleFactory.create(Car.class);
        car.run();

        IVehicle motorcycle = VehicleFactory.create(Motorcycle.class);
        motorcycle.run();


    }
}
