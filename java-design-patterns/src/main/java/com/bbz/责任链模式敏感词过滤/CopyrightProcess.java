package com.bbz.责任链模式敏感词过滤;


public class CopyrightProcess implements IProcess {

    public String doProcess(String msg) {

        return  msg.replace("毛泽东","*");
    }
}
