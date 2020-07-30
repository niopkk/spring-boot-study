package com;

public class Thread2 {


    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread2 thread2 = new MyThread2();
        thread1.start();
        thread2.start();

    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("执行1111");
            }

        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("执行222");
        }
    }


}
