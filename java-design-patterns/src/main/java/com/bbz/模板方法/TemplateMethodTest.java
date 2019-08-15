package com.bbz.模板方法;

/**
 * com.bbz.模板方法
 * <p>
 * Created by tianxin2 on 2019-08-15
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        ShoeInstallTemplate adidasBoostShoeInstall = new AdidasBoostShoeInstall();
        adidasBoostShoeInstall.installShot();
        ShoeInstallTemplate nikeJordanShoeInstall = new NikeJordanShoeInstall();
        nikeJordanShoeInstall.installShot();
    }
}
