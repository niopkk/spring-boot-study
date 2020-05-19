package com.bbz.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        numbers.stream().reduce((i, j) -> j + j).ifPresent(s -> System.out.println(s));

        numbers.stream().reduce((a, b) -> Integer.max(a, b)).ifPresent(max -> System.out.println(max));


    }
}
