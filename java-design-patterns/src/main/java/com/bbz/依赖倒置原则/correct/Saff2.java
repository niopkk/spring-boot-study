package com.bbz.依赖倒置原则.correct;

/**
 * com.bbz.依赖倒置原则.correct
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public abstract class Saff2 {

    private String name;

    public abstract void service();

    public abstract void askHelp(Boss2 boss2);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
