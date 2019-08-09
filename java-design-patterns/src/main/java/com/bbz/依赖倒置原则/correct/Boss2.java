package com.bbz.依赖倒置原则.correct;

/**
 * com.bbz.依赖倒置原则.correct
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public abstract class Boss2 {


    private Saff2 saff2;

    public Boss2(Saff2 saff2) {
        this.saff2 = saff2;
    }

    public abstract void support();

    public abstract void askHelp(Boss2 boss2);

    public Saff2 getSaff2() {
        return saff2;
    }

    public void setSaff2(Saff2 saff2) {
        this.saff2 = saff2;
    }
}
