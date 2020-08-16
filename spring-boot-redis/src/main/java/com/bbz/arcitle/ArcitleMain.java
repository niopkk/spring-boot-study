package com.bbz.arcitle;

import com.bbz.util.Maps;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArcitleMain {

    private static Jedis jedis = new Jedis("127.0.0.1");

    public static void main(String[] args) {

//        String user = "user:10001";
        String user = "user:10002";
//        String arcitle = storeArcitle(user);
//        System.out.println(arcitle);

//        arcitleVote("arcitle:1", user);


//        for (int i = 0; i < 1000; i++) {
//            storeArcitle(String.valueOf(111111), String.valueOf(i));
//        }

        System.out.println(search());

    }

    public static List<Map<String, String>> search() {
        Set<String> zrange = jedis.zrange("score:", 0, 9);

        return zrange.stream().map(s -> jedis.hgetAll(s)).collect(Collectors.toList());
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

    public static String storeArcitle(String user, String arcitleId) {

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
