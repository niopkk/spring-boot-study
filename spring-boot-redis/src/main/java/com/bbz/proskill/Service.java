package com.bbz.proskill;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.TimeUnit;

public class Service {

    private static JedisPool pool = null;

    private DistributedLock lock = new DistributedLock(pool);

    private int n = 50;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(200);
        //设置最大空闲数
        config.setMaxIdle(8);
        //设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);


        pool = new JedisPool(config, "127.0.0.1", 6379, 300);
    }


    public void seckill() {


        // 返回锁的value值，供释放锁时候进行判断
        String uuid = "";
        try {
            uuid = lock.acquire(buildKey("resource"), 300);
            --n;
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

        } finally {
            lock.release(buildKey("resource"), uuid);
        }
        System.out.println("dddddd");


    }


    public String buildKey(String key) {
        return String.format("lock:%s", key);
    }
}
