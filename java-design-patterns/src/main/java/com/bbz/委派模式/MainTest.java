package com.bbz.委派模式;

public class MainTest {

    public static void main(String[] args) {
        new Boss().command("加密", new Leader());
    }
}
