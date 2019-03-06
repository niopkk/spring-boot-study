package com.bbz.ioc.bean;


import org.apache.commons.lang3.StringUtils;

public interface BeanDefinition {

    String SINGLETION = "singleton";

    String PROTOTYPE = "prototype";

    Class<?> getBeanClass();

    String getBeanFactory();

    String getCreateBeanMethod();

    String getStaticCreateBeanMethod();

    String getBeanInitMethond();

    String getBeanDestoryMethodName();

    String getScope();

    boolean isSingleton();

    boolean isPrototype();

    default boolean validate() {
        if (getBeanClass() == null) {
            if (StringUtils.isNotBlank(getBeanFactory()) && StringUtils.isNotBlank(getCreateBeanMethod())) {
                return false;
            }
        }
        return true;
    }
}
