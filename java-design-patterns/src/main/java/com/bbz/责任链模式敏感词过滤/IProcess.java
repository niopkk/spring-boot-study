package com.bbz.责任链模式敏感词过滤;

public interface IProcess {


    /**
     * 执行处理
     *
     * @param msg
     */
    String doProcess(String msg);
}
