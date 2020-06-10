package com.bbz.spring.formework.beans.config;

public class BeanDefinition {


    /**
     * 原生bean的全限定类名称 ->com.bbz.Test
     *
     */
    private String beanClassName;

    /**
     * 是否延时加载
     */
    private boolean lazyinit = false;

    /**
     * 保存 beanName，在 IoC 容器中存储的 key
     * 类的名称-> test
     */
    private String factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyinit() {
        return lazyinit;
    }

    public void setLazyinit(boolean lazyinit) {
        this.lazyinit = lazyinit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
