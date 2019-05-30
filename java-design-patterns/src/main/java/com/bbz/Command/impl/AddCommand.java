package com.bbz.Command.impl;

import com.bbz.Command.Command;

/**
 * com.bbz.Command.impl
 * <p>
 * Created by tianxin2 on 2019-05-30
 */
public class AddCommand implements Command {

    private int a;

    private int b;

    public AddCommand(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer execute() {
        return a + b;
    }
}
