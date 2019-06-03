package com.bbz.Command;

import com.bbz.Command.impl.AddCommand;
import com.bbz.Command.impl.DivideCommand;

import java.util.Arrays;

/**
 * com.bbz.Command
 * <p>
 * Created by tianxin2 on 2019-05-30
 */
public class MainTest {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int calculate = calculator.calculate(new AddCommand(3, 4));

        System.out.println(calculate);

        int calculates = calculator.calculate(new DivideCommand(3, 4));

        System.out.println(calculates);

    }
}
