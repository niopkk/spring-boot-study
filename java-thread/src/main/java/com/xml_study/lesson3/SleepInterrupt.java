package com.xml_study.lesson3;

public class SleepInterrupt extends Object implements Runnable {


    public void run() {

        try {

            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);

            System.out.println("in run() - woke up");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted while sleeping");
            return;
        }
        System.out.println("in run() - leaving normally");
    }


    public static void main(String[] args) {

        SleepInterrupt sleepInterrupt = new SleepInterrupt();
        Thread thread = new Thread(sleepInterrupt);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");

        thread.interrupt();//中断线程

        System.out.println("in main() - leaving");

    }
}
