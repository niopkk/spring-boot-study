package com.beanfactory;

import java.util.HashMap;

public class StaticCarFatory {

    private static HashMap<String, Car> cars = new HashMap<>();

    static {
        cars.put("audi", new Car("Audi", 30000));
        cars.put("ford", new Car("Ford", 200));
    }

    public static Car getCar(String name) {

        return cars.get(name);
    }

}
