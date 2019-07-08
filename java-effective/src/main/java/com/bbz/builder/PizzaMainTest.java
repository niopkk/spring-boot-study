package com.bbz.builder;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PizzaMainTest {

    public static void main(String[] args) {


        MyPizaa build = new MyPizaa.Builder(MyPizaa.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();

        System.out.println(build.toString());

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM)
                .sauceInside().build();

        System.out.printf(calzone.toString() + "\n");


        EnumSet<Numbers> set1 = EnumSet.allOf(Numbers.class);

        // print the set
        System.out.println("Set1:" + set1);

        // create a set2 which is a copy of set1
        EnumSet<Numbers> set2 = set1.clone();

        // print the updated set
        System.out.println("Set2:" + set2);


        EnumSet<NumberTexts> setText1 = EnumSet.allOf(NumberTexts.class);

        System.out.println("setText1" + setText1);

        Set<NumberTexts> setText2 = new HashSet<>();
        setText2.add(NumberTexts.FIVE);

        System.out.println("setText2" + setText2);


    }

    public enum Numbers {
        ONE, TWO, THREE, FOUR, FIVE
    }

    public enum NumberTexts {

        ONE("1"),

        TWO("2"),

        THREE("3"),

        FOUR("4"),

        FIVE("5");

        private String code;

        NumberTexts(String code) {
            this.code = code;
        }
    }
}
