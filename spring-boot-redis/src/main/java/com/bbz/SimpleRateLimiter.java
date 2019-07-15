package com.bbz;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/**
 * com.bbz
 * <p>断尾求生 —— 简单限流Created by tianxin2 on 2019-05-29
 */
public class SimpleRateLimiter {


    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    /***
     * 限流
     * @param userId 指定用户
     * @param actionKey 的某个行为
     * @param period 在特定的时间内
     * @param maxCount 只允许发生一定的次数
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {


        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();

        Pipeline pipelined = jedis.pipelined();

        pipelined.multi();//也就是事务，能保证一系列指令的原子顺序执行
        pipelined.zadd(key, nowTs, "" + nowTs);
        pipelined.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipelined.zcard(key);
        pipelined.expire(key, period + 1);
        pipelined.exec();
        pipelined.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) {

        Jedis jedis = new Jedis("104.245.43.165");
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 50, 3));
        }
    }
}
