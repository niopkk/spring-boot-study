package com.bbz;

import com.bbz.util.Dates;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
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

//        System.out.println(Integer.toBinaryString(20200729));

//        jedis.setbit("u:sing:10000:202008", 0, false);
//        jedis.setbit("u:sing:10000:202008", 1, true);
//        jedis.setbit("u:sing:10000:202008", 2, false);
//        jedis.setbit("u:sing:10000:202008", 3, false);
//        jedis.setbit("u:sing:10000:202008", 4, false);
//        jedis.setbit("u:sing:10000:202008", 5, false);
//        jedis.setbit("u:sing:10000:202008", 6, false);
//        jedis.setbit("u:sing:10000:202008", 7, false);
//        jedis.setbit("u:sing:10000:202008", 8, false);
//        jedis.setbit("u:sing:10000:202008", 9, false);
//        jedis.setbit("u:sing:10000:202008", 10, false);
//        jedis.setbit("u:sing:10000:202008", 11, true);

//        jedis.setbit("sing:10000",20200820,true);

        jedis.set("u:sing:10000:202008", "5");
        System.out.println(jedis.get("u:sing:10000:202008"));

//        System.out.println(jedis.getbit("u:sing:10000:202008", 5));
//        System.out.println(jedis.bitcount("u:sing:10000:202008"));
//        System.out.println(jedis.bitfield("u:sing:10000:202008", "get", "u12", "0"));
//        System.out.println(jedis.bitpos("u:sing:10000:202008", true));
        //当月没有评价,需要进行弹窗
//        if (jedis.bitcount("u:sing:10000:202008") == 0) {
//            //查找上一次弹窗时间，如果没有上次弹窗时间就直接弹窗，否则，判断间隔是否为10天，大于10天进行弹窗，否则不弹窗
//            Long aLong = jedis.bitpos("u:sing:10000:202008", false);
//
//        }

        System.out.println(LocalDate.now().getDayOfMonth());
//        System.out.println(jedis.del("w"));
    }

    public void refuse(String userId, String month, int day) {
        jedis.set(String.format("u:sing:%s:%s", userId, month), String.valueOf(day));
    }

    public void doSing(String userId, String month, int day) {
        jedis.setbit(String.format("u:sing:%s:%s", userId, month), day, true);
    }

    public boolean checkSing(String userId, String month) {
        if (jedis.bitcount(String.format("u:sing:%s:%s", userId, month)) == 0) {
            int endDay = Integer.parseInt(jedis.get(String.format("u:sing:%s:%s", userId, month)));
            if (LocalDate.now().getDayOfMonth() - endDay >= 10) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
