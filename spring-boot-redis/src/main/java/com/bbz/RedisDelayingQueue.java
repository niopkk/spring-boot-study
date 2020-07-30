package com.bbz;


import com.bbz.util.Jsons;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.UUID;

public class RedisDelayingQueue {


    private Jedis jedis;

    private String queueKey;

    public RedisDelayingQueue(String queueKey) {
        this.queueKey = queueKey;
        this.jedis = new Jedis("127.0.0.1", 6379);
    }

    public void delay(Order order) {
        System.out.println("执行pro");
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, Jsons.toJson(order));
    }


    public void loop() {
        System.out.println("执行consumer");
        while (!Thread.interrupted()) {

            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500); // 歇会继续
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            String next = values.iterator().next();
            if (jedis.zrem(queueKey, next) > 0) {//拿到锁
                Order order = Jsons.fromJson(next, Order.class);
                System.out.println(order.getName());
            }

        }
    }


    public static void main(String[] args) {


    }


    static class ProducerThread implements Runnable {

        private RedisDelayingQueue queue;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Order order = new Order();
                order.setOrderNo(UUID.randomUUID().toString());
                order.setName("张三订单" + i);
                order.setState("等待支付的订单");
                queue.delay(order);
            }
        }
    }



}
