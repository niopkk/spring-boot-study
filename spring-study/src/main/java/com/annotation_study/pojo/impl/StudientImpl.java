package com.annotation_study.pojo.impl;

import com.annotation_study.pojo.IStudent;

/**
 * com.annotation_study.pojo.impl
 * <p>
 * Created by tianxin2 on 2019-09-06
 */
public class StudientImpl implements IStudent {
    @Override
    public void print() {
        System.out.println("print......student......");
    }
}
