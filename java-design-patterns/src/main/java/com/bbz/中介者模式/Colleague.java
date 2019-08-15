package com.bbz.中介者模式;

/**
 * com.bbz.中介者模式
 * <p> 抽象同事类
 * Created by tianxin2 on 2019-08-15
 */
public abstract class Colleague {


    protected String name;

    protected Mediator mediator;


    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
