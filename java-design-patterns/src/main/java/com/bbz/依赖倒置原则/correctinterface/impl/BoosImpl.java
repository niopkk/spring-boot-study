package com.bbz.依赖倒置原则.correctinterface.impl;

import com.bbz.依赖倒置原则.correctinterface.Boss;
import com.bbz.依赖倒置原则.correctinterface.Saff;

/**
 * com.bbz.依赖倒置原则.correctinterface.impl
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class BoosImpl implements Boss {

    private Saff saff;

    public BoosImpl(Saff saff) {
        this.saff = saff;
    }

    @Override
    public void support() {
        saff.service();
    }

    @Override
    public void askHelp(Boss boss) {
        boss.support();
    }
}
