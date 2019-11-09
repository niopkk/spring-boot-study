package com.volatile关键字;

public class VolatileMain {


    public static void main(String[] args) throws InterruptedException {
        VolatileThread volatileThread = new VolatileThread();

        Thread thread = new Thread(volatileThread);
        Thread thread_01 = new Thread(volatileThread);
        thread.start();
        thread_01.start();
        Thread.sleep(1000);
        volatileThread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}
