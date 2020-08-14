package com.bbz.arcitle;

import lombok.Data;
import redis.clients.jedis.Jedis;

@Data
public class Arcitle {




    private String title;

    private String link;

    private String poster;

    private long time;

    private int votes;



}
