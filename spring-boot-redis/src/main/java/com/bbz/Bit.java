package com.bbz;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Bit {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) {


//        jedis.setbit("w", 20120729, true);
//        jedis.setbit("w", 20120730, true);
//        jedis.setbit("w", 20120731, true);
//
//
//        jedis.setbit("sing_in", 10020120731L, true);
//        jedis.setbit("sing_in", 10120120731L, true);
//
//
//
//
//        System.out.println(jedis.getbit("w", 20200729));
//        System.out.println(jedis.getbit("w", 20200730));
//        System.out.println(jedis.getbit("w", 20200731));
//
//        System.out.println(jedis.bitcount("w"));
//        jedis.set("str","hi");

        System.out.println(Integer.toBinaryString(20200729));

        System.out.println(jedis.bitcount("str", 0, 1));


//        System.out.println(jedis.del("w"));
    }
}
