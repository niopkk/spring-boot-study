package com.bbz.依赖倒置原则.error;

/**
 * com.bbz.依赖倒置原则.error
 * <p>
 * Created by tianxin2 on 2019-08-09
 */
public abstract class Boss {

    abstract void support();

    abstract void askHelp(Boss boss);
}
