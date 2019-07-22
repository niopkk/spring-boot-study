package com.bbz.example_23;

/**
 * com.bbz.example_23
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
public class Figure {

    enum Shape {RECTANGLE, CIRCLE}

    final Shape shape;

    double length;
    double width;
    double radius;

    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);

        }

    }

}
