package com.bbz.proskill;

import com.bbz.util.Strings;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.UUID;

public class DistributedLock {

    private JedisPool jedisPool;


    public DistributedLock(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    /**
     * 加锁
     *
     * @param lockKeyName 锁的key
     * @param lockTimeOut 获取锁的超时时间
     * @param expired     锁的过期时间
     */
    public String lock(String lockKeyName, long lockTimeOut, long expired) {
        Jedis conn = null;
        String retIdentifier = null;

        try {

            //获取连接
            conn = jedisPool.getResource();

            //生成一个随机的key
            String identifier = UUID.randomUUID().toString();

            //锁名，即key值
            String lockKey = "lock:" + lockKeyName;

            //超时时间，上锁后超过此时时间后自动释放锁
            int lockExpired = (int) expired / 1000;

            //获取锁的超时时间，超过这个时间自动放弃获取锁
            long end = System.currentTimeMillis() + lockTimeOut;
            while (System.currentTimeMillis() < end) {
                if (conn.setnx(lockKey, identifier) == 1) {
                    conn.expire(lockKey, lockExpired);
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                //返回-1 代表key 没有设置过期时间
                if (conn.ttl(lockKey) == -1) {
                    conn.expire(lockKey, lockExpired);
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockName
     * @param identifier
     * @return
     */
    public boolean unLock(String lockName, String identifier) {
        Jedis conn = null;
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;

        try {
            conn = jedisPool.getResource();
            while (true) {
                conn.watch(lockKey);
                if (identifier.equals(conn.get(lockKey))) {
                    Transaction transaction = conn.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if (results == null) {
                        continue;
                    }
                    retFlag = true;
                }
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retFlag;
    }

    public String acquire(String key, int timeoutMills) {
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        Jedis conn = null;
        String uuid = UUID.randomUUID().toString();
        try {
            conn = jedisPool.getResource();
            long ok = conn.setnx(key, uuid);
            if (ok == 1) {
                conn.expire(key, timeoutMills);
            }
            if (conn.ttl(key) == -1L) {
                conn.expire(key, timeoutMills);
            }
            return uuid;
        } catch (Exception e) {
//            LOGGER.error("Acquire lock error is {}", e.toString());
        }finally {
            conn.close();
        }
        return null;
    }

    public void release(String key, String uuid) {
        Jedis conn = null;
        conn = jedisPool.getResource();
        while (true) {
            try {
                conn.watch(key);
                if (Strings.equals(uuid, conn.get(key))) {
                    Transaction transaction = conn.multi();
                    transaction.del(key);
                    transaction.exec();
                }
            } catch (Exception e) {
            } finally {
                conn.close();
            }
        }
    }

}
