package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class BossA extends Boss {


    private SaffA saffA;

    public BossA(SaffA saffA) {
        this.saffA = saffA;
    }

    @Override
    void support() {
        saffA.service();
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}
