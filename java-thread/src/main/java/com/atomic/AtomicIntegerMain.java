package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] ts=new Thread[10];
        for (int i = 0; i < 10; i++) {
             ts[i]=new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
        for (int i = 0; i < 10; i++) {
            ts[i].join();
        }
        System.out.println(atomicInteger);
    }
}
