package com.线程池使用;

import com.线程池使用.myenum.Locker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class MainTest {

    static int count = 0;

    public static int getCount() {
        return count;
    }

    //使用synchronized进行同步
//    public synchronized static void addCount() {
//        count++;
//    }
    //采用lock方式
    public static void addCount() {

        Lock writeLock = Locker.INSTANCE.writeLock();
        writeLock.lock();
        count++;
        writeLock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {

//        ExecutorService executorService = Executors.newCachedThreadPool();//这种方式会导致内存溢出

        ExecutorService executorService = new ThreadPoolExecutor(
                10
                , 100
                , 60L
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> MainTest.addCount());
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
            System.out.println("线程池没有关闭");
            executorService.shutdown();
        }
        System.out.println(MainTest.getCount());
    }
}
