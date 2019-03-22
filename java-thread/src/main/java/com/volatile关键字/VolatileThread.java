package com.volatile关键字;

public class VolatileThread implements Runnable {

    private volatile boolean isRunning = true;

    int m;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {

        System.out.println("进入了run");

        while (true == isRunning) {
            int a = 2;
            int b = 3;
            int c = a + b;
            m = c;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("循环内的：" + m);
        }
        System.out.println(m);
        System.out.println("线程被停止了");
    }
}
