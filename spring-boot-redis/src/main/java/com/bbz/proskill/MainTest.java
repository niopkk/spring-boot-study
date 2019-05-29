package com.bbz.proskill;

public class MainTest {


    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(service)).start();
        }

    }
}
