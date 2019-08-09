package com.bbz.依赖倒置原则.correctinterface.impl;

import com.bbz.依赖倒置原则.correctinterface.Boss;
import com.bbz.依赖倒置原则.correctinterface.Saff;

/**
 * com.bbz.依赖倒置原则.correctinterface.impl
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class SaffImpl implements Saff {


    private String name;

    public SaffImpl(String name) {
        this.name = name;
    }

    @Override
    public void service() {
        System.out.println(this.name + "提供服务");
    }

    @Override
    public void askHelp(Boss boss) {
        boss.support();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
