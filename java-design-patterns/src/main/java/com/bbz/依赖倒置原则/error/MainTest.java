package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        SaffA saffA = new SaffA("A员工");

        SaffB saffB = new SaffB("B员工");


        BossA bossA = new BossA(saffA);

        BossB bossB = new BossB(saffB);

        bossA.askHelp(bossB);

        bossB.askHelp(bossA);
    }
}
