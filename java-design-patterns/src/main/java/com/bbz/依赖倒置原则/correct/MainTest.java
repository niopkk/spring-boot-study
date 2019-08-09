package com.bbz.依赖倒置原则.correct;

import com.bbz.依赖倒置原则.correct.impl.BoosImpl;
import com.bbz.依赖倒置原则.correct.impl.SaffImpl;

/**
 * com.bbz.依赖倒置原则.correct
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public class MainTest {

    public static void main(String[] args) {


        Saff2 saff2A = new SaffImpl("A员工");

        Saff2 saff2B = new SaffImpl("B员工");

        Boss2 boss2A = new BoosImpl(saff2A);

        Boss2 boss2B = new BoosImpl(saff2B);

        boss2A.askHelp(boss2B);

        saff2B.askHelp(boss2A);


        Saff2 saff2C = new SaffImpl("C员工");

        boss2A.setSaff2(saff2C);

        saff2B.askHelp(boss2A);

    }
}
