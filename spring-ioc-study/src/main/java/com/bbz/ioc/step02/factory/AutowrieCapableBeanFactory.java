package com.bbz.ioc.step02.factory;

import com.bbz.ioc.step02.BeanDefinition;

public class AutowrieCapableBeanFactory extends AbstractBeanFactory {

    @Override
    Object doCreateBean(BeanDefinition definition) {
        try {
            Object bean = definition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
