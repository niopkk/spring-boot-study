package com.bbz.annotation04.DI容器;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
@SimpleSingleton
public class ServiceA {


    @SimpleInject
    private ServiceB serviceB;

    public void action() {
        serviceB.action();
    }
}
