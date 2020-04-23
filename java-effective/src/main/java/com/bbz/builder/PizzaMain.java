package com.bbz.builder;

public class PizzaMain {

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.MUSHROOM).builder();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.ONION).builder();

        calzone.toppings.stream().forEach(s-> System.out.println(s.name()));



    }




}
