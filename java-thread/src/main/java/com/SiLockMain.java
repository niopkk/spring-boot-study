package com;

import java.util.concurrent.TimeUnit;

public class SiLockMain implements Runnable {


    private String localA;
    private String localB;

    public SiLockMain(String localA, String localB) {
        this.localA = localA;
        this.localB = localB;
    }

    @Override
    public void run() {

        synchronized (localA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有" + localA + "尝试获取" + localB);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (localB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有" + localB + "尝试获取" + localA);
            }
        }
    }


}

class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new SiLockMain(lockA, lockB), "localA").start();
        new Thread(new SiLockMain(lockB, lockA), "localB").start();
    }
}