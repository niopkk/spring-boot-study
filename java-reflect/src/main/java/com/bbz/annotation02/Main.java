package com.bbz.annotation02;

public class Main {


    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
        Apple apple = new Apple();
        System.out.println(apple.getAppleName());
    }
}
