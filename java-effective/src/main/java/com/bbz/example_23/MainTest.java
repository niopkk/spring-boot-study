package com.bbz.example_23;

import com.bbz.example_23.youhua.Circle;
import com.bbz.example_23.youhua.Rectangle;

/**
 * com.bbz.example_23
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
public class MainTest {

    public static void main(String[] args) {

        Figure figure = new Figure(2);
        double area = figure.area();
        System.out.println(area);


        System.out.println(new Circle(2).area());
        System.out.println(new Rectangle(3, 2).area());
    }
}
