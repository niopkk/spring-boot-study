package com.bbz.适配器模式;

public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String username, Object adapter);
}
