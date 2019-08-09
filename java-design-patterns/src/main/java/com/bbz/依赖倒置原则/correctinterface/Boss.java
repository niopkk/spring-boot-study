package com.bbz.依赖倒置原则.correctinterface;

/**
 * com.bbz.依赖倒置原则.correctinterface
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public interface Boss {



    void support();

    void askHelp(Boss boss);

}
