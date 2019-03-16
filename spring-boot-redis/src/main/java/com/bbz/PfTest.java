package com.bbz;

import redis.clients.jedis.Jedis;

public class PfTest {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("192.168.10.96");


        for (int i = 0; i < 100; i++) {
            jedis.pfadd("codehole", "user" + i);

            long total = jedis.pfcount("codehole");

            if (total != 1 + i) {
                System.out.printf("%d %d\n", total, i + 1);
                break;
            }
        }
        jedis.close();
    }
}
