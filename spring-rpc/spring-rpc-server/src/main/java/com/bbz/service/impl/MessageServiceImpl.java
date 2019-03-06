package com.bbz.service.impl;

import com.bbz.service.MessageService;

public class MessageServiceImpl implements MessageService {
    @Override
    public String say() {
        return "你好!";
    }

    @Override
    public String say(String name) {
        return "你好" + name;
    }
}
