package com.ThreadLocal;

import java.util.Date;

public class Test3Main {


    public static void main(String[] args) {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("主线程中取值=" + Tools.ext.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Tools {
        public static ThreacLocalExt ext = new ThreacLocalExt();
    }

    public static class ThreacLocalExt extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    }


    public static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                System.out.println("子线程中取值=" + Tools.ext.get());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
