package com.bbz.Command;

/**
 * com.bbz.Command
 * <p>
 * Created by tianxin2 on 2019-05-30
 */
public class Calculator {

    public int calculate(Command command) {
        return command.execute();
    }
}
