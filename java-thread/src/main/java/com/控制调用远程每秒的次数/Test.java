package com.控制调用远程每秒的次数;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {

    //    http://ifeve.com/concurrency-practice-1/#more-4019
    final static int MAX_QPS = 100;

    final static Semaphore semaphore = new Semaphore(MAX_QPS);

    public static void main(String... args) throws Exception {

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {

            @Override

            public void run() {

                semaphore.release(MAX_QPS / 2);

            }

        }, 1000, 500, TimeUnit.MILLISECONDS);//1000毫秒后开始执行, 执行周期是500毫秒

        //lots of concurrent calls:100 * 1000
        ExecutorService pool = Executors.newFixedThreadPool(100);

        for (int i = 100; i > 0; i--) {

            final int x = i;

            pool.submit(() -> {

//                for (int j=6;j>0;j--) {

                while (true) {
                    semaphore.acquireUninterruptibly(1);

                    remoteCall(x, 1);

                }

//                }

            });

        }

//        pool.shutdown();
//
//        pool.awaitTermination(1, TimeUnit.HOURS);

//        System.out.println("DONE");
    }

    private static void remoteCall(int i, int j) {
        System.out.println(String.format("%s ,%s- %s: %d %d", System.currentTimeMillis(), new Date(),
                Thread.currentThread(), i, j));
    }

}
