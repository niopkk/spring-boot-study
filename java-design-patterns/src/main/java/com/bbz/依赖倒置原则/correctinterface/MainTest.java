package com.bbz.依赖倒置原则.correctinterface;

import com.bbz.依赖倒置原则.correctinterface.impl.BoosImpl;
import com.bbz.依赖倒置原则.correctinterface.impl.SaffImpl;

/**
 * com.bbz.依赖倒置原则.correctinterface
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        Saff saffA = new SaffImpl("A员工");

        Saff saffB = new SaffImpl("B员工");

        Boss bossA = new BoosImpl(saffA);

        Boss bossB = new BoosImpl(saffB);

        bossA.askHelp(bossB);

        saffB.askHelp(bossA);


    }
}
