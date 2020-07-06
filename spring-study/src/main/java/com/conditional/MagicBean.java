package com.conditional;


public class MagicBean {
    static {
        System.out.println("静态代码块初始化........");
    }


    public void hello() {
        System.out.println("hello");
    }
}
