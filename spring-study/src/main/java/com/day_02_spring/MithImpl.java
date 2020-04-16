package com.day_02_spring;

import org.springframework.stereotype.Component;

@Component
public class MithImpl implements MithI {


    @Override
    public int add(int i, int j) {
        int result = i + j;

        return result;
    }

    @Override
    public int miu(int i, int j) {
        int result = i - j;

        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;

        return result;
    }


}
