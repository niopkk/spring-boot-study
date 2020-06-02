package com.bbz.service.impl;

import com.bbz.annotation.Service;
import com.bbz.service.IDemoService;

@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    public String get(String name) {
        return "my name is " + name;
    }
}
