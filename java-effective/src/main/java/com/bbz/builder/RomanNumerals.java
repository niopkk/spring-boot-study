package com.bbz.builder;

import java.util.regex.Pattern;

public class RomanNumerals {

    private static final Pattern ROMAN = Pattern.compile("");

    static boolean isRomanNumeral(String s) {

        return ROMAN.matcher(s).matches();
    }
}
