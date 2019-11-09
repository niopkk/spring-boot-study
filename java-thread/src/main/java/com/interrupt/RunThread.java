package com.interrupt;

public class RunThread {


    public static void main(String[] args) throws InterruptedException {


        InterruptMyThread myThread = new InterruptMyThread();
        System.out.println("start");
        myThread.start();
        try {
            Thread.sleep(20000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end");
//        InterruptMyThread t=new InterruptMyThread();
//        t.start();
//        Thread.sleep(2000);
//        t.interrupt();
    }
}
