package com.bbz.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Method square = MethodTableTest.class.getMethod("square", double.class);

        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1,10,10,square);

        printTable(1,10,10,sqrt);
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double form, double to, int n, Method f) {
        System.out.println(f);


        double y = 0;
        try {
            y = (Double) f.invoke(null, form);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.printf("%10.4f | %10.4f%n", form, y);
    }

//    public static void printTable(double form, double to, int n, Method f) {
//        System.out.println(f);
//        double dx = (to - form) / (n - 1);
//
//        for (double x = form; x <= to; x += dx) {
//            try {
//                double y = (Double) f.invoke(null, x);
//                System.out.printf("%10.4f | %10.4f%n", x, y);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
