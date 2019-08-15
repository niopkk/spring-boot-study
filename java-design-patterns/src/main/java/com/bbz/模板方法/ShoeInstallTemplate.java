package com.bbz.模板方法;

/**
 * com.bbz.模板方法
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public abstract class ShoeInstallTemplate {


    protected abstract void installSole();

    protected abstract void installInsole();

    protected abstract void installVamp();

    protected abstract void installShoelace();

    public void installShot() {

        installSole();

        installInsole();

        installVamp();

        installShoelace();
    }
}
