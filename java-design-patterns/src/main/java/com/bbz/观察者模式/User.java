package com.bbz.观察者模式;

public class User implements Observer {


    private int id;

    private String name;

    private String message;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    private void read() {

        System.out.println(name + ":收到推送消息:" + message);
    }
}
