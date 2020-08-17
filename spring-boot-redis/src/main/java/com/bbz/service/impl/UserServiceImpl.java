package com.bbz.service.impl;

import com.bbz.service.UserService;
import com.bbz.util.Streams;
import com.bbz.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static long LIMIT = 10000;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public Map<String,Object> checkToken(String token) {
       return (Map<String, Object>) redisTemplate.opsForHash().get("login:", token);
    }

    @Override
    public void updateToken(String token, String userId, String item) {
        long now = System.currentTimeMillis();
        redisTemplate.opsForHash().put("login:", token, userId);
        redisTemplate.opsForZSet().add("recent:", token, now);
        if (Strings.isNotBlank(item)) {
            redisTemplate.opsForZSet().add("viewed:" + token, item, now);
            redisTemplate.opsForZSet().removeRangeByScore("viewed:" + token, 0, -26);
        }
    }

    @Override
    public void cleanSessions() {
        while (true) {
            Long size = redisTemplate.opsForZSet().zCard("recent:");
            if (size <= LIMIT) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long endIndex = Math.max(size - LIMIT, 100);
            Set<String> tokens = redisTemplate.opsForZSet().range("recent:", 0, endIndex);
            List<String> lists = Streams.of(tokens).map(item -> "viewed:" + item).collect(Collectors.toList());
            redisTemplate.delete(lists);
            redisTemplate.opsForHash().delete("login:", tokens);
            redisTemplate.opsForZSet().remove("recent:", tokens);

        }
    }
}
