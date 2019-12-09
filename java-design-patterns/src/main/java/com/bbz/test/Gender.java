package com.bbz.test;

import java.util.Arrays;

/**
 * com.bbz.test
 * <p>
 * Created by tianxin2 on 2019/12/9
 */
public enum Gender {


    M("男"),
    F("女");

    private String des;

    Gender(String des) {
        this.des = des;
    }

    public Gender formDes(String name) {
        return Arrays.stream(Gender.values()).filter(g -> g.equals(name)).findAny().orElse(Gender.M);
    }

    public Gender formDes(Gender gender) {
        if (gender != null) {
            return formDes(gender.name());
        }
        return Gender.M;
    }
}
