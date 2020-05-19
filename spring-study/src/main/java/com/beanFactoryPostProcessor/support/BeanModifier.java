package com.beanFactoryPostProcessor.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Calendar;

public class BeanModifier implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


        Calendar calendar = Calendar.getInstance();

        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition("welcomer");
            beanDefinition.getPropertyValues().add("welcomeText", "Good afternoon");
        }
    }
}
