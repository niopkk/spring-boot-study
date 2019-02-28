package com.lesson;

public interface UserDao {

    void save(User user);

    User load(String name);
}
