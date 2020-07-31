package com.bbz.redisDelayingQueq;

public class ConsumerThread {

    public static void main(String[] args) {


        RedisDelayingQueue queue = new RedisDelayingQueue("order_queue");

        Thread consumerThread = new Thread(() -> queue.loop());
        consumerThread.setName("线程0");
        consumerThread.start();
        RedisDelayingQueue queue1 = new RedisDelayingQueue("order_queue");
        Thread consumerThread1 = new Thread(() -> queue1.loop());
        consumerThread1.setName("线程1");
        consumerThread1.start();
    }
}
