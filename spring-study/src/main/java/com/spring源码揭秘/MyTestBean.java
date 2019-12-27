package com.spring源码揭秘;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * com.spring源码揭秘
 * <p>
 * Created by tianxin2 on 2019/12/24
 */
public class MyTestBean {
    private String testStr;

    public MyTestBean() {
        this.testStr="111";
    }

    public MyTestBean(String testStr) {
        this.testStr = testStr;
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Class<?> aClass = Class.forName("com.spring源码揭秘.MyTestBean");
        System.out.println(aClass);
        final  MyTestBean myTestBean = (MyTestBean)aClass.newInstance();
        System.out.println(myTestBean.getTestStr());
    }

    class  testC extends DefaultListableBeanFactory {

    }
}
