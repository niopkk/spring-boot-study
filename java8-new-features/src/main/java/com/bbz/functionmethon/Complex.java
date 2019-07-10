package com.bbz.functionmethon;


/**
 * com.bbz.functionmethon
 * <p>
 * Created by tianxin2 on 2019-07-10
 *
 * @author tianxin2
 */
public final class Complex {

    private final double re;

    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return this.re;
    }

    public double imaginaryPart() {
        return this.im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex tiems(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divideBy(Complex c) {
        double temp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / temp, (im * c.re - re * c.im) / temp);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
