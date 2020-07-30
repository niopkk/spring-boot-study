package com.bbz.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ZAddParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtil {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void set(String key, String value) {
        jedis.set(key, value);
        jedis.setex("", 2, "33333");
    }

    public static Long incr(String key) {
        return jedis.incr(key);
    }

    public static String get(String key) {
        return jedis.get(key);
    }

    public static List<String> lrang(String key, long start, final long stop) {
        return jedis.lrange(key, start, stop);
    }


    public static Long lpush(String key, String... value) {
        return jedis.lpush(key, value);
    }

    public static String lpop(String key) {
        return jedis.lpop(key);
    }

    public static Long rpush(String key, String... value) {
        return jedis.rpush(key, value);
    }

    public static String rpop(String key) {
        return jedis.rpop(key);
    }

    public static Long hset(String key, Map<String, String> value) {
        return jedis.hset(key, value);
    }

    public static String hget(String key, String value) {
        return jedis.hget(key, value);
    }

    /**
     * set 添加
     *
     * @param key
     * @param value
     * @return
     */
    public static Long sadd(String key, String value) {
        return jedis.sadd(key, value);
    }

    /**
     * 获取set值
     *
     * @param key
     * @return
     */
    public static Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    /**
     * 弹出set的值
     *
     * @param key
     * @return
     */
    public static String spop(String key) {
        return jedis.spop(key);
    }

    /**
     * 获取 set key 数量
     *
     * @param key
     * @return
     */
    public static Long scard(String key) {
        return jedis.scard(key);
    }

    /**
     * 判断 set key 中的某值是否存在
     *
     * @param key
     * @param file
     * @return
     */
    public static Boolean sismember(String key, String file) {
        return jedis.sismember(key, file);
    }

    public static Long zadd(String key, double score, String value) {
        return jedis.zadd(key, score, value);
    }


    public static Set<String> zrange(String key, long start, final long stop) {
        return jedis.zrange(key, start, stop);
    }

    public static Set<String> zrevrange(String key, long start, final long stop) {
        return jedis.zrevrange(key, start, stop);
    }

    public static Set<String> zrevrangeByScore(String key, long start, final long stop) {
        return jedis.zrevrangeByScore(key, start, stop);
    }

    public static Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        return jedis.zrangeByScore(key, min, max, offset, count);
    }

    public static Long zrem(String key, String... values) {
        return jedis.zrem(key, values);
    }


    public static Long zadd(String key, double score, String value, ZAddParams params) {
        return jedis.zadd(key, score, value, params);
    }
}
