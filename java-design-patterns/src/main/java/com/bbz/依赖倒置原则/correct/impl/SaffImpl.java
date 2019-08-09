package com.bbz.依赖倒置原则.correct.impl;

import com.bbz.依赖倒置原则.correct.Boss2;
import com.bbz.依赖倒置原则.correct.Saff2;

/**
 * com.bbz.依赖倒置原则.correct.impl
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class SaffImpl extends Saff2 {

    public SaffImpl(String name) {
        this.setName(name);
    }

    @Override
    public void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    public void askHelp(Boss2 boss2) {
        boss2.support();
    }
}
