package com.bbz.状态模式;

public class ConcreteStateA extends State {

    @Override
    public void handle1() {
        System.out.println("业务A下执行的业务逻辑");
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.concreteStateB);
        super.context.handle2();
    }
}
