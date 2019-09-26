package com.bbz.enumtest;

/**
 * com.bbz.enumtest
 * <p>
 * Created by tianxin2 on 2019-09-16
 */
public class Student {

    public enum AccountType {
        /**
         * 默认的账号-不支持删除
         */
        DEFAULT,
        /**
         * 受保护的，不支持删除
         */
        ADDED;
    }


    private AccountType accountType;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
