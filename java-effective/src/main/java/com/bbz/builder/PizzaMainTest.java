package com.bbz.builder;

public class PizzaMainTest {

    public static void main(String[] args) {


        MyPizaa build = new MyPizaa.Builder(MyPizaa.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM)
                .sauceInside().build();

        System.out.printf(calzone.toString());
    }
}
