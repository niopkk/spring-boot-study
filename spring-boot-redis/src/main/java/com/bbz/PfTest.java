package com.bbz;

import com.bbz.util.Jsons;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class PfTest {

    private static final String FANC = "fanc_";

    public static void main(String[] args) {


        Jedis jedis = new Jedis("144.34.149.150");
        jedis.set("name", "11113333");
        System.out.println(jedis.get("name"));

//        jedis.setex("names",10,"23");
        System.out.println(jedis.get("names"));



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
