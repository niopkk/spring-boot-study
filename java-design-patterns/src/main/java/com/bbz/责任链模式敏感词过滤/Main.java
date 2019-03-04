package com.bbz.责任链模式敏感词过滤;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        String msg = "这个一个敏感词测试毛泽东是一个伟大的政治家==";


        MsgProcessChain chain = new MsgProcessChain()
                .addChain(new SensitiveWordProcess())
                .addChain(new CopyrightProcess());

        msg = chain.process(msg);
        System.out.printf(msg);

    }


}
