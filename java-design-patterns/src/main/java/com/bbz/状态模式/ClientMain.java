package com.bbz.状态模式;

public class ClientMain {

    public static void main(String[] args) {
        Context context = new Context();

        context.setCurrentState(new ConcreteStateA());
        context.handle1();
        context.handle2();
    }
}
