package com.bbz.test;

import java.util.List;

public class MyMain {
    public static void main(String[] args) {


//        SqlSession sqlSession = new SqlSession();
        MyInterface mappger = SqlSession.getMappger(MyInterface.class);
        List<Integer> query = mappger.query();

        query.stream().forEach(str-> System.out.println(str));
        System.out.println((query));
    }
}
