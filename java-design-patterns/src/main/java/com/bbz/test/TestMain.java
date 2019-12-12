package com.bbz.test;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/**
 * com.bbz.test
 * <p>
 * Created by tianxin2 on 2019/12/10
 */
public class TestMain {


    public static void main(String[] args) {
//        int a = 0x12345678;
//
//        System.out.println(Integer.toBinaryString(a));
//        int r = Integer.reverse(a);
//        System.out.println(Integer.toBinaryString(r));
//        int rb = Integer.reverseBytes(a);
//        System.out.println(Integer.toHexString(rb));
//
//        System.out.println(Charset.defaultCharset().name());


        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID() + ":" + tz.getDisplayName());

        System.out.println(Locale.getDefault());
        Random random = new Random();
        System.out.println(random.nextInt(100));
    }
}
