package com.bbz.ioc.step05.factory;

import com.bbz.ioc.step05.BeanDefinition;
import com.bbz.ioc.step05.BeanRefernce;
import com.bbz.ioc.step05.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanDefinition(beanDefinition);
        beanDefinition.setBean(bean);
        //属性赋值
        applyProperBeanDefinition(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanDefinition(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    private void applyProperBeanDefinition(Object bean, BeanDefinition mod) throws Exception {

        for (PropertyValue propertyValue : mod.getPropertyValues().getPropertyValues()) {
            Field field = mod.getBeanClass().getDeclaredField(propertyValue.getName());

            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanRefernce) {
                BeanRefernce beanRefernce = (BeanRefernce) propertyValue.getValue();
                value = getBean(beanRefernce.getName());
            }
            field.set(bean, value);
        }
    }
}
