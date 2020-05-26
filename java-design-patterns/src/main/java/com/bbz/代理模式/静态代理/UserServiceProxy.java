package com.bbz.代理模式.静态代理;

public class UserServiceProxy {

    //定义被代理的对象
    private UserService userService;


    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }


    public String login(String account, String password) {
        System.out.println("调用前的方法");
        String result = userService.login(account, password);
        System.out.println("调用后的方法");
        return result;
    }
}
