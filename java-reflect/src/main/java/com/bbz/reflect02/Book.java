package com.bbz.reflect02;

public class Book {
    public Book() {
        System.out.println("book 构造函数");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //    @Override
//    public String toString() {
//        return "这是重写了book toString()方法";
//    }
}
