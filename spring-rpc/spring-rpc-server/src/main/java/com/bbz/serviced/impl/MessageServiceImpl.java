package com.bbz.serviced.impl;

import com.bbz.serviced.MessageService;

public class MessageServiceImpl implements MessageService {
    @Override
    public String say() {
        return "dsdfsdf";
    }

    @Override
    public String say(String name) {
        return "dsfds" + name;
    }
}
