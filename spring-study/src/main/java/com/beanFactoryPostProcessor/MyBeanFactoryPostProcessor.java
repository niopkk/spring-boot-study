package com.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;


public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String beanName : beanDefinitionNames) {
            System.out.println("MyBeanFactoryPostProcessor........" + beanName);
            if (beanName.equals("person")) {
                final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("name", "ddddsdf"));

                System.out.println(beanDefinition.toString());
                System.out.println("修改person.name的值");
            }

        }


//        final BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
//        beanDefinition.setAttribute("name","重新赋值操作");

    }
}
