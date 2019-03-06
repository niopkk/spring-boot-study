package com.bbz.ioc.bean.impl;

import com.bbz.ioc.bean.BeanDefinition;

public class DefaultBeanDefinition implements BeanDefinition {
    private Class<?> classzz;

    private String beanFactoryName;

    private String createBeanMethodName;

    private String staticCreateBeanMethod;

    private String beanInitMethodName;

    private String beanDestoryMethodName;

    private boolean isSingleton;

    public Class<?> getClasszz() {
        return classzz;
    }

    public void setClasszz(Class<?> classzz) {
        this.classzz = classzz;
    }

    public String getBeanFactoryName() {
        return beanFactoryName;
    }

    public void setBeanFactoryName(String beanFactoryName) {
        this.beanFactoryName = beanFactoryName;
    }

    public String getCreateBeanMethodName() {
        return createBeanMethodName;
    }

    public void setCreateBeanMethodName(String createBeanMethodName) {
        this.createBeanMethodName = createBeanMethodName;
    }

    public void setStaticCreateBeanMethod(String staticCreateBeanMethod) {
        this.staticCreateBeanMethod = staticCreateBeanMethod;
    }

    public String getBeanInitMethodName() {
        return beanInitMethodName;
    }

    public void setBeanInitMethodName(String beanInitMethodName) {
        this.beanInitMethodName = beanInitMethodName;
    }

    public void setBeanDestoryMethodName(String beanDestoryMethodName) {
        this.beanDestoryMethodName = beanDestoryMethodName;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }

    @Override
    public Class<?> getBeanClass() {
        return this.classzz;
    }

    @Override
    public String getBeanFactory() {
        return this.beanFactoryName;
    }

    @Override
    public String getCreateBeanMethod() {
        return this.createBeanMethodName;
    }

    @Override
    public String getStaticCreateBeanMethod() {
        return this.staticCreateBeanMethod;
    }

    @Override
    public String getBeanInitMethond() {
        return this.beanInitMethodName;
    }

    @Override
    public String getBeanDestoryMethodName() {
        return this.beanDestoryMethodName;
    }

    @Override
    public String getScope() {
        return this.isSingleton ? BeanDefinition.SINGLETION : BeanDefinition.PROTOTYPE;
    }

    @Override
    public boolean isSingleton() {
        return this.isSingleton;
    }

    @Override
    public boolean isPrototype() {
        return !this.isSingleton;
    }
}
