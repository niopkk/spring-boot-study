package com.bbz.适配器模式;

public class MainTest {

    public static void main(String[] args) {
        IPassportForThird passport = new PassportForThird();
        passport.loginForQQ("1111");
        passport.loginForSina("222");
    }
}
