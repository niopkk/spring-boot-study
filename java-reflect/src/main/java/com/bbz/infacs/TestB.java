package com.bbz.infacs;

public class TestB {

    private final TestA testA;

    private final TestA testD;

    public TestB() {
        this.testA = new TestC();
        this.testD = new TestD();
    }


    public String singC() {
        return this.testA.say();
    }
    public String singD() {
        return this.testD.say();
    }


}
