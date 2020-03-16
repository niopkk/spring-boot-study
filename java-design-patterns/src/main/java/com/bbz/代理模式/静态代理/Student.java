package com.bbz.代理模式.静态代理;

public class Student implements UserService {
    @Override
    public String login(String account, String password) {
        System.out.println("ssssss");
        return "student登陆成功";
    }
}
