package com.bbz.redisDelayingQueq;

import java.util.UUID;

public class ProducerThread {

    public static void main(String[] args) {
        RedisDelayingQueue queue = new RedisDelayingQueue("order_queue");
//
//        Thread thread = new Thread(new ProducerThread(queue));
//        thread.start();

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() + 300000);

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Order order = new Order();
                order.setOrderNo(UUID.randomUUID().toString());
                order.setName("张三订单" + i);
                order.setState("等待支付的订单");
                queue.delay(order);
            }
        });
        producerThread.start();
    }
}
