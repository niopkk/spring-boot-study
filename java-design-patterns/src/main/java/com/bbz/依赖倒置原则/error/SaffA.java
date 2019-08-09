package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class SaffA extends Saff {

    public SaffA(String name) {
        this.setName(name);
    }

    @Override
    void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}
