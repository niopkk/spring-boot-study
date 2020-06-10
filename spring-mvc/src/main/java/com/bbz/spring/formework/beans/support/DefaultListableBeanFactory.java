package com.bbz.spring.formework.beans.support;

import com.bbz.spring.formework.beans.config.BeanDefinition;
import com.bbz.spring.formework.context.support.AbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DefaultListableBeanFactory extends AbstractApplicationContext {

    /**
     *
     */
    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
}
