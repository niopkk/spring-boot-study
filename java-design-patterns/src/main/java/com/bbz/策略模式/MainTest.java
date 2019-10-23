package com.bbz.策略模式;

import java.util.ArrayList;
import java.util.List;

/**
 * com.bbz.策略模式
 * <p>
 * Created by tianxin2 on 2019/10/21
 */
public class MainTest {

    public static void main(String[] args) {
//        int exec = new Content(new Shop()).exec(1, 2);
//        int exec1 = new Content(new Shop1()).exec(1, 2);

        List<Strategy> strategies = new ArrayList<>();
        strategies.add(new Shop());
        strategies.add(new Shop1());
        for (Strategy s : strategies) {
            int add = s.add(1, 3);
            System.out.println(add);
        }
//        System.out.println(exec);
    }
}
