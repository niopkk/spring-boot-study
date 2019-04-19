package com.bbz.reflect02.demoFactory;

public class MainTest {


    public static void main(String[] args) {
//        Fruit fruit = Factory.getInstance("apple");
//
//        fruit.eat();
//
//        Fruit fruit1 = Factory.getInstance("orange");
//
//        fruit1.eat();
//
        Fruit fruit = Factory.getInstance("com.bbz.reflect02.demoFactory.Apple");
        fruit.eat();

    }
}
