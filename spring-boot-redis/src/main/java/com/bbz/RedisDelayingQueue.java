package com.bbz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.*;


public class RedisDelayingQueue<T> {


    static class TaskItem<T> {
        public String id;
        private T msg;

        public T getMsg() {
            return msg;
        }

        public void setMsg(T msg) {
            this.msg = msg;
        }
    }

    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();

    private Jedis jedis;
    private String queueKey;


    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<T>();
        // 分配唯一的 uuid
        task.id = UUID.randomUUID().toString();
        task.setMsg(msg);
        // fastjson 序列化
        String s = JSON.toJSONString(task);
        // 塞入延时队列 ,5s 后再试
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            // 只取一条
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    // 歇会继续
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            // 抢到了
            if (jedis.zrem(queueKey, s) > 0) {
                // fastjson 反序列化
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                this.handleMsg(task.getMsg());
            }
        }
    }

    public void handleMsg(T msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {
//
//
//        Jedis jedis = new Jedis("104.245.43.165",6379,300);
        Jedis jedis = new Jedis("104.245.43.165");

        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("codehole" + i);
            }
        });
        Thread consumer = new Thread(() -> queue.loop());
        producer.start();
        consumer.start();
        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
        }
    }
}
