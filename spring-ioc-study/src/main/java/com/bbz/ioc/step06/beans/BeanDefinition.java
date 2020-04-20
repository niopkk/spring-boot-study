package com.bbz.ioc.step06.beans;

public class BeanDefinition {

    private Object bean;

    private Class classBean;

    private String classBeanName;

    private PropertyValues propertyValues=new PropertyValues();

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getClassBean() {
        return classBean;
    }

    public void setClassBean(Class classBean) {
        this.classBean = classBean;
    }

    public String getClassBeanName() {
        return classBeanName;
    }

    public void setClassBeanName(String classBeanName) {
        this.classBeanName = classBeanName;
        try {
            this.classBean=Class.forName(classBeanName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
