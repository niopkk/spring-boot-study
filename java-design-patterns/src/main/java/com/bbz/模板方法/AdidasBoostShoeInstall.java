package com.bbz.模板方法;

/**
 * com.bbz.模板方法
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class AdidasBoostShoeInstall extends ShoeInstallTemplate {

    @Override
    protected void installSole() {
        System.out.println("组装白色 Boost 鞋底");
    }

    @Override
    protected void installInsole() {
        System.out.println("组装黑色 Boost 鞋垫");
    }

    @Override
    protected void installVamp() {
        System.out.println("组装黑色 Boost 鞋面");
    }

    @Override
    protected void installShoelace() {
        System.out.println("组装黑色 Boost 鞋带");
    }
}
