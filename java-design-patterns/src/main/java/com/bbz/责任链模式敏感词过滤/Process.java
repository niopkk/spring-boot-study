package com.bbz.责任链模式敏感词过滤;

public interface Process {


    /**
     * 执行处理
     *
     * @param msg
     */
    String doProcess(String msg);


    class SensitiveWordProcess implements Process {
        @Override
        public String doProcess(String msg) {
            return msg.replace("==", "*");
        }
    }

    class CopyrightProcess implements Process {

        @Override
        public String doProcess(String msg) {
            return msg.replace("毛泽东", "*");
        }
    }
}
