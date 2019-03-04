package com.bbz.reflect02.demoFactory;

public class Factory {

    public static Fruit getInstance(String className) {

        //未使用反射的用法
//        if ("apple".equals(className)) {
//            return new Apple();
//        } else if ("orange".equals(className)) {
//            return new Orange();
//        }
        //使用反射
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
