package com.bbz.annotation04.aop;


/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */

public class ServiceA {


    @SimpleInject
    private ServiceB serviceB;

    public void action() {
        serviceB.action();
    }
}
