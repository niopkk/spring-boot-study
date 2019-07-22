package com.bbz.example_23.youhua;

/**
 * com.bbz.example_23.youhua
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
public class Circle extends Figure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
