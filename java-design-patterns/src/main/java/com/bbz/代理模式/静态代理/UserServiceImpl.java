package com.bbz.代理模式.静态代理;

public class UserServiceImpl implements UserService {
    @Override
    public String login(String account, String password) {

        if ("admin".equals(account) && "123456".equals(password)) {
            System.out.println("登陆成功!");
            return "success";
        } else {
            System.out.println("登陆失败");
            return "error";
        }
    }
}
