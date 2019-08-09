package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class BossB extends Boss {


    private SaffB saffB;

    public BossB(SaffB saffB) {
        this.saffB = saffB;
    }

    @Override
    void support() {
        saffB.service();
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}
