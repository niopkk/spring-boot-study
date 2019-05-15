package com.bbz.单例模式;

import com.bbz.单例模式.饿汉式.Singleton;

/**
 * com.bbz.单例模式
 * <p>
 * Created by tianxin2 on 2019-05-15
 */
public class MainTest {

    public static void main(String[] args) {

        final String s = Singleton.getInstance().get("http://www.biying.com");
        System.out.println(s);
    }
}
