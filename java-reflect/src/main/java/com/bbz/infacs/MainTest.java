package com.bbz.infacs;

import java.lang.ref.WeakReference;

public class MainTest {

    public static void main(String[] args) {
//        TestC testC=new TestC();
//        testC.say();
//        System.out.println(testC.say());


        TestB testB = new TestB();

        testB.singC();
        System.out.println(testB.singC());
        System.out.println(testB.singD());

        if ("ds".equalsIgnoreCase("DS")) {
            System.out.println("dsddsd");
        }
        double y = Math.pow(3, 4);
        System.out.println(y);


        WeakReference d = new WeakReference("dsd");

        System.out.println(500 * 4468);
    }
}