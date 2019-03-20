package com.static和非static修饰的区别;

import java.util.Random;

public class Testmain {

    public static void main(String[] args) {

        Random random = new Random();

        int s = new Random().nextInt(20 - 18 + 1) + 18;
        System.out.println(s);
    }
}
