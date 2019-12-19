package com.bbz.annotation04.DI容器;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class ServiceC {

    public ServiceA serviceA;

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void action(){
        serviceA.action();;
    }
}
