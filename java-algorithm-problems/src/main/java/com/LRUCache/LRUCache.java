package com.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * com.LRUCache
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class LRUCache extends LinkedHashMap<String, String> {


    private int maxEntries;

    public LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > maxEntries;
    }
}
