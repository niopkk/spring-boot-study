package com.bbz.di.factory.impl;



import com.bbz.di.bean.BeanDefinitionRegistery;
import com.bbz.di.factory.Factory;

import java.io.Closeable;
import java.io.IOException;

public class DefaultDefinitionFactory implements BeanDefinitionRegistery, Factory, Closeable {


    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
