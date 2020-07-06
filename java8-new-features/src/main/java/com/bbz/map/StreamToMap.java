package com.bbz.map;

import com.bbz.util.Lists;
import com.bbz.util.Strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamToMap {

    private static final String NULL = Strings.EMPTY;

    public static void main(String[] args) {
        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());

        Map<String, String> languageNames = locals.collect(Collectors.toMap(Locale::getDisplayLanguage,
                l -> l.getDisplayLanguage(l),
                (oldValue, newValue) -> oldValue
        ));
        System.out.println(languageNames);

        locals = Stream.of(Locale.getAvailableLocales());
        final Map<String, Set<String>> setMap = locals.collect(Collectors.toMap(Locale::getDisplayCountry,
                l -> Collections.singleton(l.getDisplayLanguage()),
                (a, b) -> {
                    Set<String> union = new HashSet<>();
                    union.addAll(b);
                    return union;
                }
        ));

        System.out.println(setMap);
        locals = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locals.collect(
                Collectors.partitioningBy(locale -> locale.getLanguage().equals("en")
                ));

        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        List<Locale> englishLocalesOther = englishAndOtherLocales.get(false);
        System.out.println(englishAndOtherLocales);
        System.out.println(englishLocales);
        System.out.println(englishLocalesOther);


        locals = Stream.of(Locale.getAvailableLocales());
        final Map<String, Set<Locale>> mapSet = locals.collect(
                groupingBy(Locale::getCountry,
                        Collectors.toSet()));
        System.out.println(mapSet);


        //下游收集器
        locals = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocalCounts = locals.collect(groupingBy(Locale::getCountry, counting()));
        System.out.println(countryToLocalCounts);

        locals = Stream.of(Locale.getAvailableLocales());
        Map<String, Optional<String>> collect = locals.collect(groupingBy(Locale::getCountry, mapping(Locale::getDisplayName, maxBy(Comparator.comparing(String::toLowerCase)))));
        System.out.println(collect);


        List<Integer> values = Lists.of(1, 2, 3);
        Optional<Integer> reduce = values.stream().reduce(Integer::sum);

        System.out.println(reduce.get());


        //list<List<String>> 转set
        List<List<String>> lists = new ArrayList<>();
        lists.add(Lists.of("1111"));
        lists.add(Lists.of("2222"));
        lists.add(Lists.of("3333"));
        lists.add(Lists.of("4444"));
        lists.add(Lists.of(""));
        Set<String> collect2 = lists.stream().flatMap(strings -> strings.stream()).collect(Collectors.toSet());
        System.out.println(collect2);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("111", "333");
        stringMap.put("22", NULL);

    }
}
