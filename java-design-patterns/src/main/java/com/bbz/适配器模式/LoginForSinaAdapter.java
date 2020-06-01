package com.bbz.适配器模式;

public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }


    @Override
    public ResultMsg login(String username, Object adapter) {
        return null;
    }
}
