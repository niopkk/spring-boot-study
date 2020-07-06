package com.bbz;

import com.bbz.util.Lists;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Encode encode = derive -> derive.encrypt();

        encode.encode(new Derive());

        Encode encode1 = derive -> derive.te("tttt");
        encode1.encode(new Derive());


        List<String> strings = Lists.of("1", "2", "3", "4", "5", "6", "7");


        strings.forEach(s -> {
            if ("3".equals(s)) {
                return;
            }
            System.out.println(s);
        });

        for (String s : strings) {

            if ("3".equals(s)) {
                return;
            }
            System.out.println(s);

        }

    }
}
