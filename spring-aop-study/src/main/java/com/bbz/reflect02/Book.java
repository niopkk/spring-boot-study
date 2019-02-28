package com.bbz.reflect02;

public class Book {
    public Book() {
        System.out.println("book 构造函数");
    }

    @Override
    public String toString() {
        return "这是重写了book toString()方法";
    }
}
