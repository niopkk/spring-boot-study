package com.bbz.arcitle;

import com.bbz.util.Maps;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class ArcitleMain {

    private static Jedis jedis = new Jedis("127.0.0.1");

    public static void main(String[] args) {

//        String user = "user:10001";
        String user = "user:10002";
//        String arcitle = storeArcitle(user);
//        System.out.println(arcitle);

        arcitleVote("arcitle:1", user);
    }


    static long oneWeekInSeconds = 7 * 8600;
    static int voteScore = 432;

    public static void arcitleVote(String arcitle, String user) {
        long cutOff = System.currentTimeMillis() - oneWeekInSeconds;

        if (jedis.zscore("time:", arcitle) < cutOff)
            return;
        String arcitleId = arcitle.split(":")[1];
        if (jedis.sadd("voted:" + arcitleId, user) == 0) {
            jedis.zincrby("score:", voteScore, arcitle);
            jedis.hincrBy(arcitle, "votes", 1);
        }
    }

    public static String storeArcitle(String user) {
        String arcitleId = jedis.incr("arcitle:").toString();

        String voled = "voled:" + arcitleId;

        jedis.sadd(voled, user);

        long now = System.currentTimeMillis();
        String arcitle = "arcitle:" + arcitleId;

        jedis.hmset(arcitle, Maps.of("title", "测试文章111",
                "link", "www.baidu.com",
                "poster", user,
                "time", String.valueOf(now),
                "votes", String.valueOf(1)
        ));
        jedis.zadd("score:", now + voteScore, arcitle);
        jedis.zadd("time:", now, arcitle);

        return arcitleId;
    }
}
