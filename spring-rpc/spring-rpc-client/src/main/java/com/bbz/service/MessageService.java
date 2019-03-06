package com.bbz.service;

import com.bbz.annotation.RpcClient;

@RpcClient
public interface MessageService {

    String say();

    String say(String name);
}
