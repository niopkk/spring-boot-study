package com.线程池使用.myenum;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum Locker {

    INSTANCE;

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Lock writeLock() {
        return lock.writeLock();
    }
}
