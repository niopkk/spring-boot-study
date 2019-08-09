package com.bbz.依赖倒置原则.correct.impl;

import com.bbz.依赖倒置原则.correct.Boss2;
import com.bbz.依赖倒置原则.correct.Saff2;

/**
 * com.bbz.依赖倒置原则.correct.impl
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class BoosImpl extends Boss2 {


    public BoosImpl(Saff2 saff2) {
        super(saff2);
    }

    @Override
    public void support() {
        this.getSaff2().service();
    }

    @Override
    public void askHelp(Boss2 boss2) {
        boss2.support();
    }
}
