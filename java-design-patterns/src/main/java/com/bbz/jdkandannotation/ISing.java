package com.bbz.jdkandannotation;

import com.bbz.jdkandannotation.annotation.RpcClient;

@RpcClient("rpc测试是否")
public interface ISing {


    String add(String name);

    int del(int id);
}
