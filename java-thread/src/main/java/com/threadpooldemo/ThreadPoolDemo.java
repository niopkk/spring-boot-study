package com.threadpooldemo;

import java.util.concurrent.*;

/**
 * com.threadpooldemo
 * <p>
 * Created by tianxin2 on 2020/1/14
 */
public class ThreadPoolDemo {

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread Id: " + Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(10000 * 0.004);

        MyTask task = new MyTask();
        ExecutorService exec = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 11; i++) {
            exec.submit(task);
        }
//        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            final ScheduledFuture<String> schedule = scheduledExecutorService.schedule(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return "dsdfsfdfd";
//                }
//            }, 1, TimeUnit.SECONDS);
//            try {
//                System.out.println(schedule.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
