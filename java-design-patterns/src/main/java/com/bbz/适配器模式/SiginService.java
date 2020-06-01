package com.bbz.适配器模式;

public class SiginService {

    public ResultMsg regist(String username, String password) {
        return new ResultMsg(100, "注册成功", new Member());

    }

    public ResultMsg login(String username, String password) {
        return null;
    }
}
