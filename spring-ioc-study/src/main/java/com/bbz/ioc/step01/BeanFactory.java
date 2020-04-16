package com.bbz.ioc.step01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private final static Map<String, BeanDefinition> bdMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String beanName) {
        return bdMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        bdMap.put(name, beanDefinition);
    }
}
