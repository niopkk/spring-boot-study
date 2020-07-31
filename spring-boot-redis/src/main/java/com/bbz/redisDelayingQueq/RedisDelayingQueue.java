package com.bbz.redisDelayingQueq;


import com.bbz.util.Jsons;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisDelayingQueue {


    private Jedis jedis;

    private String queueKey;

    public RedisDelayingQueue(String queueKey) {
        this.queueKey = queueKey;
        this.jedis = new Jedis("127.0.0.1", 6379);
    }

    public void delay(Order order) {
        System.out.println("执行pro:" + order.getOrderNo());
        jedis.zadd(queueKey, System.currentTimeMillis() + 30, Jsons.toJson(order));//设置延时队列
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
            if (!values.isEmpty()) {
                String next = values.iterator().next();
                if (jedis.zrem(queueKey, next) > 0) {//拿到锁
                    Order order = Jsons.fromJson(next, Order.class);
                    System.out.println(order.getName());
                }
            }

        }
    }
}
