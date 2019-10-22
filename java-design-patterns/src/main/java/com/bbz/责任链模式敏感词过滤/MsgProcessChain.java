package com.bbz.责任链模式敏感词过滤;

import java.util.ArrayList;
import java.util.List;

public class MsgProcessChain {


    private List<IProcess> chains;

    public MsgProcessChain() {
        chains = new ArrayList<>();
    }

    public MsgProcessChain addChain(IProcess IProcess) {

        chains.add(IProcess);
        return this;
    }

    public String process(String msg) {

        for (IProcess chain : chains) {
//            System.out.println("开始处理.......：" + msg);
            msg = chain.doProcess(msg);
//            System.out.println("处理结束.......：" + msg);
        }

        return msg;
    }
}
