package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public abstract class Saff {

    private String name;

    abstract void service();

    abstract void askHelp(Boss boss);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
