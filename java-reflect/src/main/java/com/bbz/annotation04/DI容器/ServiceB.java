package com.bbz.annotation04.DI容器;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
@SimpleSingleton
public class ServiceB {

    private String name;

    public void action(){
        System.out.println("I'm B");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
