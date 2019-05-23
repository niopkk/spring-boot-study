package com.JAVASPI;

import com.bbz.Search;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * com.JAVASPI
 * <p>
 * Created by tianxin2 on 2019-05-23
 */
public class MainTest {

    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> searchs = s.iterator();
        if (searchs.hasNext()) {
            Search curSearch = searchs.next();
            curSearch.search("test");
        }
    }
}
