package com.bbz.statics;

import java.util.Random;

public class MainTest {

    static int count = 0;

    public static void main(String[] args) {

        StaticTest staticTest = new StaticTest();

        new Thread(() -> {

            while (true) {
                count++;
                try {
                    Thread.sleep(1000);
                    System.out.println(staticTest.getData());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count % 5 == 0) {
                    staticTest.setData(System.currentTimeMillis());
                }
            }
        }).start();

    }
}
