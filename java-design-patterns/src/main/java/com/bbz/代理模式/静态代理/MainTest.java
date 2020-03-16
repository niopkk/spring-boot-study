package com.bbz.代理模式.静态代理;

public class MainTest {

    public static void main(String[] args) {
//        UserService service = new UserServiceImpl();
//
//        UserServiceProxy proxy = new UserServiceProxy(service);
//        proxy.login("admin", "123456");

        UserService student = new Student();

        UserServiceProxy proxy1 = new UserServiceProxy(student);
        proxy1.login("", "");
    }
}
