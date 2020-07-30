package com.bbz;

import com.bbz.util.Jsons;
import com.bbz.util.Maps;
import com.bbz.util.RedisUtil;

import java.awt.geom.RectangularShape;
import java.util.Map;

public class String_01 {

    public static void main(String[] args) {

//        RedisUtil.set("name", "张三");

//        RedisUtil.set("age", "111");

//        String name = RedisUtil.get("name");


//        System.out.println(name);
        System.out.println(RedisUtil.incr("age"));
        String json = Jsons.toJson(new Person("zhang", 23, "男"));
        RedisUtil.set("person", json);


        RedisUtil.hset("map", Maps.of("name", Jsons.toJson(new Person("李四", 23, "女"))));

        System.out.println(RedisUtil.get("person"));
        System.out.println(RedisUtil.hget("map", "name"));

//        RedisUtil.sadd("setpseron",Jsons.toJson(new Person("李四", 23, "女")));
//        System.out.println(RedisUtil.spop("setpseron"));


        RedisUtil.zadd("zlist", 2.1d, Jsons.toJson(new Person("李四", 23, "女")));
        RedisUtil.zadd("zlist", 3.3, Jsons.toJson(new Person("王五", 43, "男")));
        RedisUtil.zadd("zlist", 4.3, Jsons.toJson(new Person("3223", 43, "男")));
        RedisUtil.zadd("zlist", 4.3, Jsons.toJson(new Person("3223", 43, "男")));
        System.out.println("===========");
        RedisUtil.zrevrange("zlist", 0, 2).stream().forEach(s -> {
            System.out.println(s);
        });

    }


}
