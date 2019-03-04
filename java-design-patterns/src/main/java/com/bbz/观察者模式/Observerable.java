package com.bbz.观察者模式;

/**
 * 定义一个抽象被观察者接口
 */
public interface Observerable {


    /**
     * 添加
     */
    void reginterObserver(Observer observer);

    /**
     * 删除
     */
    void removeObserver(Observer observer);

    /**
     * 通知
     */
    void notifyObserver();
}
