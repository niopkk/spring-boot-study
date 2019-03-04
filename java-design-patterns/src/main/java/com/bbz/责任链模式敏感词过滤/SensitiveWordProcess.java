package com.bbz.责任链模式敏感词过滤;


/**
 *过滤==
 */
public class SensitiveWordProcess implements IProcess {


    public String doProcess(String msg) {

        return msg.replace("==", "*");
    }
}
