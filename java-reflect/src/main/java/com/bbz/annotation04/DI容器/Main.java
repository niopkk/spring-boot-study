package com.bbz.annotation04.DI容器;

import java.util.Optional;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        ServiceA serviceA = SimpleContainer.getInstance(ServiceA.class);
        serviceA.action();


        Object s = "122";
        System.out.println(Optional.ofNullable(s).map(i -> i.toString()).orElse("111"));
    }

}
