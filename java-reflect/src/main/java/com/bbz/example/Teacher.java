package com.bbz.example;

/**
 * com.bbz.example
 * <p>
 * Created by tianxin2 on 2019-09-26
 */
public class Teacher {

    private int age;

    public Teacher() {

    }

    public Teacher(Integer age) {
        System.out.println("有参构造方法...." + age);
        this.age = age;
    }

    public Teacher(String dsddddd) {
        System.out.println("有参构造方法...." + dsddddd);

    }


    public void getName(String name) {

        System.out.println(name + "非static");
    }

    public static void getSubject(String subject) {
        System.out.println(subject + ".....static");
    }

    private void getSex(String sex) {
        System.out.println(sex + ".......私有方法");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
