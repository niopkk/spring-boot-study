package com.bbz.模版方法;

/**
 * com.bbz.模版方法
 * <p>
 * Created by tianxin2 on 2019/12/6
 */
public class Childer extends Base {


    @Override
    protected void step1() {
        System.out.println("childer step..." + this.currendtStep);
    }

    @Override
    protected void setp2() {
        System.out.println("childer step..." + this.currendtStep);
    }
}
