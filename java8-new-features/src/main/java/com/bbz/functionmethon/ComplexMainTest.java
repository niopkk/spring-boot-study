package com.bbz.functionmethon;

/**
 * com.bbz.functionmethon
 * <p>
 * Created by tianxin2 on 2019-07-10
 */
public class ComplexMainTest {

    public static void main(String[] args) {


        Complex b = new Complex(3, 4);
        Complex c = new Complex(1, 1);
        System.out.println(b + "*" + c + "=" + b.tiems(c));


    }
}
