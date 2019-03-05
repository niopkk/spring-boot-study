package com.bbz.代理模式.代理案例.impl;


import com.bbz.代理模式.代理案例.IUserManage;

public class UserManagerImpl implements IUserManage {

    @Override
    public String add(String name) {
//        System.out.println("添加add");

        return "添加add";
    }

    @Override
    public int del(int id) {
//        System.out.println("删除del");

        return 1;
    }
}
