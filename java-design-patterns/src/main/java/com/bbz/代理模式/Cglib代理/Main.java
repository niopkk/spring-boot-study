package com.bbz.代理模式.Cglib代理;

public class Main {

    public static void main(String[] args) {


        Singer singer = new Singer();
        Singer proxy = new ProxyFactory().ProxyFactory(Singer.class);
        proxy.sing();
    }
}
