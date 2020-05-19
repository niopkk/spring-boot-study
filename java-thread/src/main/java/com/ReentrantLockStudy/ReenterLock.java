package com.ReentrantLockStudy;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    private static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();//加锁
            try {
                i++;
            } finally {
                lock.unlock();//解锁
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);


    }
}
