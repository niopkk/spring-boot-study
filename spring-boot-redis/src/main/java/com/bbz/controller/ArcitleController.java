package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arcitle")
public class ArcitleController extends BaseController {

    private static Jedis jedis = new Jedis("127.0.0.1");


    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/search")
    public ResultView search() {

//        Set<String> zrange = jedis.zrange("score:", 0, 9);

        Set<String>  range= redisTemplate.opsForZSet().range("score:", 0, 9);


        return okResult("查询成功!", range.stream().map(s -> jedis.hgetAll(s)).collect(Collectors.toList()));
    }

}
