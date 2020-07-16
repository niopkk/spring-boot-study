package com.bbz.support;

public class TokenDetailImpl implements TokenDetail {

    private final String userName;

    public TokenDetailImpl(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }


}
