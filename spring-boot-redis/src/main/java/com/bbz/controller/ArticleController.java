package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.service.ArticleService;
import com.bbz.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {

//    private static Jedis jedis = new Jedis("127.0.0.1");


    @Autowired
    private ArticleService articleService;


    @GetMapping("/search")
    public ResultView search() {

//        Set<String> zrange = jedis.zrange("score:", 0, 9);

//        Set<String>  range= redisTemplate.opsForZSet().range("score:", 0, 9);
//
//
//        return okResult("查询成功!", range.stream().map(s -> jedis.hgetAll(s)).collect(Collectors.toList()));

        return okResult("查询成功!", articleService.search(0, 20, "score:"));
    }

    @GetMapping("/groupSearch")
    public ResultView groupSearch() {
        return okResult("查询成功!", articleService.groupSearch("经济", 0, 20));
    }

    @GetMapping("/store")
    public ResultView store() {

        for (int i = 0; i < 1000; i++) {
            articleService.store("1000000", String.valueOf(i));

        }

        return okResult("保存成功!");
    }

    @GetMapping("/group")
    public ResultView group() {
        for (int i = 0; i < 10; i++) {
            articleService.addRemoveGroups(String.valueOf(i), new String[]{"经济"}, new String[]{""});
        }
        return okResult("分组成功!");
    }

    @GetMapping("/articleVote")
    public ResultView articleVote() {
        articleService.articleVote("1000002", "2");
        return okResult("投票成功!");
    }

}
