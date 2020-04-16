package com.bbz.ioc.step04.facotry;

import com.bbz.ioc.step04.BeanDefinition;
import com.bbz.ioc.step04.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropterValue(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropterValue(Object bean, BeanDefinition mbd) throws Exception {

        for (PropertyValue properValue : mbd.getPropertyValues().getProperValues()) {
            Field declaredField = mbd.getBeanClass().getDeclaredField(properValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, properValue.getValue());
        }
    }
}
