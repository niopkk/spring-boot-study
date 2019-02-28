package com.bbz.reflect;

public class TestClass {

    private String MSG = "Original";

    private void privateMethod(String head, int tail) {
        System.out.println(head + " " + tail);
    }

    public String getMSG() {
        return MSG;
    }
}
