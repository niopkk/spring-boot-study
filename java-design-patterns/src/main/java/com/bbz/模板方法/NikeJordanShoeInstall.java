package com.bbz.模板方法;

/**
 * com.bbz.模板方法
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class NikeJordanShoeInstall extends ShoeInstallTemplate {
    @Override
    protected void installSole() {
        System.out.println("组装黑色 Jordan 鞋底");
    }

    @Override
    protected void installInsole() {
        System.out.println("组装黑色 Jordan 鞋垫");
    }

    @Override
    protected void installVamp() {
        System.out.println("组装红色 Jordan 鞋面");
    }

    @Override
    protected void installShoelace() {
        System.out.println("组装红色 Jordan 鞋带");
    }
}
