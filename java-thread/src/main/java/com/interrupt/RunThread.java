package com.interrupt;

public class RunThread {


    public static void main(String[] args) throws InterruptedException {


        InterruptMyThread myThread = new InterruptMyThread();
        System.out.println("start");
        myThread.start();
        try {
            System.out.println("进入休眠.....");
            Thread.sleep(20000);
            System.out.println("进入休眠111.....");
            myThread.interrupt();
            System.out.println("进入休眠3333.....");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();

        }
        myThread.join();
        System.out.println("end");
//        InterruptMyThread t=new InterruptMyThread();
//        t.start();
//        Thread.sleep(2000);
//        t.interrupt();
    }
}
