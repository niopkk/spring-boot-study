package com.bbz.模版方法;

/**
 * com.bbz.模版方法
 * <p>
 * Created by tianxin2 on 2019/12/6
 */
public class Base {

    protected int currendtStep;

    protected void step1() {

    }

    protected void setp2() {

    }

    public void action() {

        this.currendtStep = 1;
        step1();
        this.currendtStep = 2;
        setp2();
    }
}
