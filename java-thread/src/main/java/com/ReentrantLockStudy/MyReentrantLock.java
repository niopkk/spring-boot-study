package com.ReentrantLockStudy;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock implements Runnable {

    public ReentrantLock lock = new ReentrantLock();
    public int i = 0;


    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            try {
                i++;
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }




}
