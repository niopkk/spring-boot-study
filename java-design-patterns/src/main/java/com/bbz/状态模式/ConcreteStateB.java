package com.bbz.状态模式;

public class ConcreteStateB extends State {

    @Override
    public void handle2() {
        System.out.println("状态B下执行的业务逻辑");
    }

    @Override
    public void handle1() {
        super.context.setCurrentState(Context.concreteStateA);
        super.context.handle1();
    }
}
