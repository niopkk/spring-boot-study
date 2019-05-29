package com.bbz.proskill;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Service {

    private static JedisPool pool = null;

    private DistributedLock lock = new DistributedLock(pool);

    private int n = 500;

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

        pool = new JedisPool(config, "104.224.176.144", 6379, 6000);
    }


    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        String identifier = lock.lock("resource", 5000, 1000);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        lock.unLock("resource", identifier);

        if (n == 0) {
            System.out.println("秒杀以结束");
        }

    }


}
