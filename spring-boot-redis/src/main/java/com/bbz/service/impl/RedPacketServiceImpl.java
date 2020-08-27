package com.bbz.service.impl;

import com.bbz.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired
    private RedisTemplate redisTemplate;


    private final String RED_PACKET_CONSUME_KEY = "repacket:consum:";
    private final String RED_PACKET_KEY = "redpacket:";
    private final String ID_KEY = "id:generator:redpacket";

    public int rob(long redid, long userId) {
        Object packet = this.redisTemplate.opsForHash().get(RED_PACKET_CONSUME_KEY + redid, String.valueOf(userId));
        if (packet == null) {
            Object obj = this.redisTemplate.opsForList().leftPop(RED_PACKET_KEY + redid);
            if (obj != null) {
                this.redisTemplate.opsForHash().put(RED_PACKET_CONSUME_KEY + redid, String.valueOf(userId), obj);

                return (Integer) obj;
            }
            //代表抢完
            return -1;

        }
        //代表以抢
        return -2;
    }

    public long setRedPacket(int total, int count) {
        Integer[] packet = this.splitRedPacket(total, count);
        long n = this.incrementId();
        String key = RED_PACKET_KEY + n;
        this.redisTemplate.opsForList().leftPushAll(key, packet);
        this.redisTemplate.expire(key, 3, TimeUnit.DAYS);
        return n;
    }

    public Long incrementId() {
        return this.redisTemplate.opsForValue().increment(ID_KEY);
    }

    public Integer[] splitRedPacket(int total, int count) {
        int use = 0;
        Integer[] array = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                array[i] = total - use;
            } else {
                int avg = (total - use) * 2 / (count - i);
                array[i] = 1 + random.nextInt(avg - 1);
            }
            use = use + array[i];
        }
        return array;
    }


}
