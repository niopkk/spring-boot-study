package com.ReentrantLockStudy;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {


        //        Thread thread1 = new Thread(new MyReentrantLock(), "线程" + 1);
//        Thread thread2 = new Thread(new MyReentrantLock(), "线程" + 2);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//
        //共享一个变量（需要加锁保证变量的一致性）
        MyReentrantLock lock = new MyReentrantLock();
        new Thread(lock, "线程1").start();
        new Thread(lock, "线程2").start();


        //不共享变量
//        Thread thread1 = new Thread(new MyReentrantLock(), "线程" + 1);
//        Thread thread2 = new Thread(new MyReentrantLock(), "线程" + 2);
//        thread1.start();
//        thread2.start();
    }
}
