package com.bbz;

import com.bbz.util.Maps;
import com.bbz.util.Strings;
import com.google.gson.internal.$Gson$Preconditions;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Optional;
import java.util.UUID;

public class List {

    private static Jedis jedis = new Jedis("127.0.0.1");

    public static void main(String[] args) {

//        jedis.set("hello", "word");
//        System.out.println(jedis.get("hello"));
//        jedis.del("hello");
//
//        jedis.lpush("11", "333");
//
//        System.out.println(jedis.lindex("11", 0));
//
//        System.out.println(jedis.incr("arcile:"));
//
//        jedis.hset("21", Maps.of("1","2"));


    }



}
