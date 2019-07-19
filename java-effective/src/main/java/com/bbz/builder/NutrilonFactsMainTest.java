package com.bbz.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NutrilonFactsMainTest {

    public static void main(String[] args) {

        NutritionFacts cocaColal = new NutritionFacts.Builder(240, 0)
                .calories(100).soduim(35).carbohydrate(27).builder();


        System.out.printf(cocaColal.toString());

        Map<String, String> maps = new HashMap<>();
        maps.put("k", "123");
        maps.put("a", "323");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(maps);


        final List<Map<String, String>> collect = list.stream().map(e ->
                e.entrySet().stream()
                        .filter(map -> map.getValue() == "123")
                        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
        ).collect(Collectors.toList());

        System.out.println(collect);



    }
}
