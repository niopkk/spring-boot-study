package com.volatile关键字;

/**
 * com.volatile关键字
 * <p>
 * Created by tianxin2 on 2019/11/8
 */
public class TestVolatile {

    public volatile int inc = 0;

    private void increase() {
        inc++;
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    testVolatile.increase();
                }
            }).start();
        }
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(testVolatile.inc);
    }
}
