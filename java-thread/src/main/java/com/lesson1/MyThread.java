package com.lesson1;

public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("" + name + "卖出=" + ticket--);
            }
        }
    }

    public static void main(String[] args) {

        /**
         * 每个线程卖了5张
         */
        new MyThread("线程1").start();
        new MyThread("线程2").start();
        new MyThread("线程3").start();
    }
}
