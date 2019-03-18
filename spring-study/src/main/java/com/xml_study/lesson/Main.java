package com.xml_study.lesson;


public class Main {

    public static void main(String[] args) {
        UserDao userDao = UserDaoFactory.createUserDao(MemoryUserDao.class);

        User user = new User();

        user.setId(1111);
        user.setName("张三历史");

        userDao.save(user);

        System.out.println(userDao.load("张三历史").getName());


    }
}
