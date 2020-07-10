package com.LRUCache;

/**
 * com.LRUCache
 * <p>
 * Created by tianxin2 on 2019/12/13
 */
public class LRUMain {

    public static void main(String[] args) {


        LRUCache lruCache = new LRUCache(2);
        lruCache.put("a", "abstract");
        lruCache.put("b", "basic");
        lruCache.put("c", "call");
        lruCache.get("a");
        lruCache.put("d", "call");

        System.out.println(lruCache);
    }
}
