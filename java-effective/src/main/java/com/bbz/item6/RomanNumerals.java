package com.bbz.item6;

import java.util.regex.Pattern;

public class RomanNumerals {

    //缓存一个Pattern 对象减小内存开销
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static Boolean isRomanNumeralSlow(String s) {
//不好的写法
//        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
//                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        return ROMAN.matcher(s).matches();
    }


    public static void main(String[] args) {

    }
}
