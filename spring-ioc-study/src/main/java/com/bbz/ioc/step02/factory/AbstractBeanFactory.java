package com.bbz.ioc.step02.factory;


import com.bbz.ioc.step02.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private final static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 放到子类通过反射进行实例化
     * @param definition
     * @return
     */
    abstract Object doCreateBean(BeanDefinition definition);
}
