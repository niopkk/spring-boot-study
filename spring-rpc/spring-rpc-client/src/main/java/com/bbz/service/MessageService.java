package com.bbz.service;

import com.bbz.annotation.RpcClient;
import com.bbz.model.Student;

public interface MessageService {

    @RpcClient(value = "say")
    String say();

    @RpcClient(value = "say")
    String say(String name);


    @RpcClient("findById")
    Student findById(String id);
}
