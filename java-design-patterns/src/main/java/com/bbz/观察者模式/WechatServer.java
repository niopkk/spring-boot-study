package com.bbz.观察者模式;


import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 */
public class WechatServer implements Observerable {

    private final long MAXMESSAGECOUNT = 2;

    private List<Observer> list;

    private String message;

    public WechatServer() {
        list = new ArrayList<>();
    }


    @Override
    public void reginterObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(message);
        }
    }


    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务器更新消息:" + s);
        notifyObserver();
    }
}
