package com.xml_study.lesson6;

public class MissedNotify {

    private Object proceedLock;

    public MissedNotify() {
        print("in MissedNotify()");
        proceedLock = new Object();
    }

    public void waitToProceed() throws InterruptedException {
        print("in waitToProceed() - entered");

        synchronized (proceedLock) {
            print("in waitToProceed() - about to wait()");
            proceedLock.wait();
            print("in waitToProceed() - back from wait()");
        }

        print("in waitToProceed() - leaving");
    }

    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

}
