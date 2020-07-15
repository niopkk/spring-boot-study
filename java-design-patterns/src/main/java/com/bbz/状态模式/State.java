package com.bbz.状态模式;

public abstract class State {

    Context context;


    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void  handle1();

    public abstract void  handle2();
}
