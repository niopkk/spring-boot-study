package com.bbz.代理模式.JDK动态代理.没有实现类的代理;

public class MainTest {

    public static void main(String[] args) {

//        Poxy poxy=new Poxy();
//        ISing iSing = ISing.getPoxy(ISing.class);
//        String say = iSing.say();
//        System.out.println(say);


        NotImplProxy.ISing proxy = NotImplProxy.getProxy(NotImplProxy.ISing.class);
        System.out.println(proxy.say());
    }
}
