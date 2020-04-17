package com.bbz.ioc.step01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    /**
     * 将BeanDefinition保存在Map对象中
     */
    private final Map<String, BeanDefinition> bdMap = new ConcurrentHashMap<>();

    /**
     * 根据key获取 BeanDefinition的对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return bdMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        bdMap.put(name, beanDefinition);
    }
}
