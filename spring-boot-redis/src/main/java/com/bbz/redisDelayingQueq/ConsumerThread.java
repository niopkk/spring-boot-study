package com.bbz.redisDelayingQueq;

public class ConsumerThread {

    public static void main(String[] args) {
        RedisDelayingQueue queue = new RedisDelayingQueue("order_queue");
        Thread consumerThread = new Thread(() -> queue.loop());
        consumerThread.start();
    }
}
