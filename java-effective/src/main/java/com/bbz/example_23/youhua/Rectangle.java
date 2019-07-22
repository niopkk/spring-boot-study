package com.bbz.example_23.youhua;

/**
 * com.bbz.example_23.youhua
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
public class Rectangle extends Figure {

    private double width;

    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }
}
