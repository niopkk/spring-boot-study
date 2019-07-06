package com.bbz.builder;

public class NutrilonFactsMainTest {

    public static void main(String[] args) {

        NutritionFacts cocaColal = new NutritionFacts.Builder(240, 0)
                .calories(100).soduim(35).carbohydrate(27).builder();


        System.out.printf(cocaColal.toString());
    }
}
