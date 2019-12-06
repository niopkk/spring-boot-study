package com.ThreadLocal;

import java.util.concurrent.CountDownLatch;

/**
 * com.ThreadLocal
 * <p>
 * Created by tianxin2 on 2019/11/13
 */
public class ThreadLocalDemo {


    public static void main(String[] args) throws InterruptedException {
        int threads = 3;

        CountDownLatch countDownLatch = new CountDownLatch(3);
        InnerClass innerClass = new InnerClass();
        for (int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread-" + i).start();
        }
//        countDownLatch.wait();
    }

    public static class InnerClass {


        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();

            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    public static class Counter {
        private static ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(() -> new StringBuilder());
    }
}
