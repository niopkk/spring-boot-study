package com.bbz.状态模式;

public class Context {

    public final static ConcreteStateA concreteStateA = new ConcreteStateA();

    public final static ConcreteStateB concreteStateB = new ConcreteStateB();

    public State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
