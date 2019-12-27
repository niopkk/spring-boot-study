package com.spring源码揭秘;

import org.springframework.beans.factory.FactoryBean;

/**
 * com.spring源码揭秘
 * <p>
 * Created by tianxin2 on 2019/12/27
 */
public class CarFactoryBean implements FactoryBean<Car> {


    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
