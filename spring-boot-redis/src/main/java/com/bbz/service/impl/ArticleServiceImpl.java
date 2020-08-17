package com.bbz.service.impl;

import com.bbz.service.ArticleService;
import com.bbz.util.Lists;
import com.bbz.util.Maps;
import com.bbz.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static long oneWeekInSeconds = 7 * 86400000;
    private static int voteScore = 432000;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Map<String, Object>> search(int pageIndex, int pageSize, String key) {
        Set<String> set = redisTemplate.opsForZSet().range(key, (pageIndex - 1) * pageSize, ((pageIndex - 1) * pageSize) + pageSize - 1);
        return Streams.of(set).map(item -> (Map<String, Object>) redisTemplate.opsForHash().entries(item)).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> groupSearch(String group, int pageIndex, int pageSize) {
        String key = "score:" + group;
        if (!redisTemplate.hasKey(key)) {
            redisTemplate.opsForZSet().intersectAndStore("group:" + group, "score:", key);
            redisTemplate.expire(key, 60, TimeUnit.SECONDS);
        }
        return search(pageIndex, pageSize, key);
    }

    @Override
    public String store(String userId, String articleId) {


        redisTemplate.opsForSet().add("voted:" + articleId, userId);

        long now = System.currentTimeMillis();
        String article = "article:" + articleId;

        redisTemplate.opsForHash().putAll(article, Maps.of(
                "articleId", articleId,
                "title", "测试文章111",
                "link", "www.baidu.com",
                "poster", userId,
                "time", now,
                "votes", 1
        ));
        redisTemplate.opsForZSet().add("score:", article, now + voteScore);
        redisTemplate.opsForZSet().add("time:", article, now);
        return articleId;
    }

    @Override
    public void addRemoveGroups(String articleId, String[] toAdd, String[] toRemove) {

        for (String group : toAdd) {
            redisTemplate.opsForSet().add("group:" + group, String.format("article:%s", articleId));
        }
        for (String group : toRemove) {
            redisTemplate.opsForSet().remove("group:" + group, String.format("article:%s", articleId));
        }
    }


    @Override
    public void articleVote(String userId, String articleId) {
        double cutOff = System.currentTimeMillis() - oneWeekInSeconds;
        String article = "article:" + articleId;
        if (redisTemplate.opsForZSet().score("time:", article) < cutOff)
            return;
        if (redisTemplate.opsForSet().add("voted:" + articleId, userId) == 1) {
            redisTemplate.opsForZSet().incrementScore("score:", article, voteScore);
            redisTemplate.opsForHash().increment(article, "votes", 1);
        }
    }

}
