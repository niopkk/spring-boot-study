package com.bbz.观察者模式;

public class Main {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();


        Observer userZ = new User("张三", 1);

        Observer userL = new User("李四", 2);

        Observer userW = new User("王五", 3);

        server.reginterObserver(userZ);
        server.reginterObserver(userL);
        server.reginterObserver(userW);
        server.setInfomation("你好");


        Observer userLL = new User("李四111", 4);
        server.reginterObserver(userLL);
        server.removeObserver(userZ);

        server.setInfomation("你好");




    }
}
