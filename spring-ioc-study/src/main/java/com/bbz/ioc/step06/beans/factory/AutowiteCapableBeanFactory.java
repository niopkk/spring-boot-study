package com.bbz.ioc.step06.beans.factory;

import com.bbz.ioc.step06.beans.BeanDefinition;
import com.bbz.ioc.step06.BeanRefernce;
import com.bbz.ioc.step06.beans.PropertyValue;

import java.lang.reflect.Field;

public class AutowiteCapableBeanFactory extends AbstarcBeanFactory {


    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

        Object bean = createBeanDefinition(beanDefinition);
        beanDefinition.setBean(bean);
        applyProperValue(bean, beanDefinition);
        return bean;
    }


    private Object createBeanDefinition(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getClassBean().newInstance();
    }

    private void applyProperValue(Object bean, BeanDefinition beanDefinition) throws Exception {

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {

            Field declaredField = beanDefinition.getClassBean().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanRefernce) {
                BeanRefernce beanRefernce = (BeanRefernce) value;
                //解决循环引用问题
                value = getBean(beanRefernce.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
