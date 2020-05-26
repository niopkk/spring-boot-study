package com.bbz.工厂.非标准;

public class StudentFactory extends Factory {
    @Override
    protected Student getStudent() {
        return new Student("历史", 1);
    }
}
