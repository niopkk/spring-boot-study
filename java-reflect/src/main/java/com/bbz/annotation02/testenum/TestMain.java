package com.bbz.annotation02.testenum;

public class TestMain {


    public static void main(String[] args) {
        String dd = "BIG";


        GameEnum.method();

        System.out.println(GameEnum.getDes(GameEnum.SMALL.getCode()));

        System.out.println(GameEnum.BIG.equals(dd));
    }

}
