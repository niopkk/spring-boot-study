package com.xml_study.lesson;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserDao implements UserDao {

    private static Map users = new HashMap();


    public void save(User user) {
        users.put(user.getName(), user);
    }

    public User load(String name) {
        return (User) users.get(name);
    }
}
