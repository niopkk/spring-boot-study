package com.bbz;

import com.bbz.util.Jsons;
import com.bbz.util.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.*;

public class PfTest {

    private static final String FANC = "fanc_";

    public static void main(String[] args) {


        Jedis jedis = new Jedis("144.34.149.150");
        jedis.set("name", "11113333");
        System.out.println(jedis.get("name"));

        jedis.setex("names",10,"23");



//        Fans fans_01 = new Fans();
//        fans_01.setName("go");
//        fans_01.setId("3");
//        Fans fans_02 = new Fans();
//        fans_02.setName("java");
//        fans_02.setId("1");
//        Fans fans_03 = new Fans();
//        fans_03.setName("python");
//        fans_03.setId("2");
//
//        String[] strings = new String[]{Jsons.toJson(fans_01), Jsons.toJson(fans_02), Jsons.toJson(fans_03)};
//        jedis.rpush("books", strings);

//        final List<String> books = jedis.lrange("books", 0, -1);
//        System.out.println(books);

        jedis.hset("hbooks", new HashMap<String, String>() {
            {
                put("java", "think java");
                put("go", " go sdd ");
                put("python", "python this");
            }
        });

        jedis.hset("hbook", "java", "think in java");


        String[] strings = new String[]{"1", "2", "3"};
        List<String> of = Lists.of(strings);
        System.out.println(Arrays.toString(of.stream().toArray(String[]::new)));

        Map<String, String> hbooks = jedis.hgetAll("hbook");
        hbooks.forEach((k, v) -> System.out.println(v));
        System.out.println(Jsons.toJson(hbooks));

        Long hbook = jedis.hlen("hbook");
        System.out.println(hbook);

        jedis.sadd("sbook", "python","python","32");
        jedis.sadd("zbook", "java");
        System.out.println(jedis.smembers("sbook"));
        System.out.println(jedis.smembers("zbook"));
        jedis.zadd("ss",1,"23");
        System.out.println(jedis.zrange("ss",0,-1));

//        Fans fans = new Fans();
//
//        fans.setId("456");
//        fans.setName("李四");
//        jedis.zadd(FANC + "123", System.currentTimeMillis(), Jsons.toJson(fans));
//
//
//        final Set<String> zrange = jedis.zrange(FANC + "123", 0, -1);
//        System.out.println(Jsons.toJson(zrange));
//
//

//        for (int i = 0; i < 100000; i++) {
//            jedis.pfadd("codehole", "user" + i);
//
//            long total = jedis.pfcount("codehole");
//
//            if (total != 1 + i) {
//                System.out.printf("%d %d\n", total, i + 1);
//                break;
//            }
//        }
//        String mingling = "multi/exec/discard";

//        "multi/exec/discard";
        jedis.close();
    }


    public static class Fans {
        private String id;

        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
