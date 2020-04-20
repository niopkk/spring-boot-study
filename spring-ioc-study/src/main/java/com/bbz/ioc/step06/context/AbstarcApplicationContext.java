package com.bbz.ioc.step06.context;

import com.bbz.ioc.step06.beans.factory.AbstarcBeanFactory;

public abstract class AbstarcApplicationContext implements ApplicationContext {

    protected AbstarcBeanFactory beanFactory;

    public AbstarcApplicationContext(AbstarcBeanFactory abstarcBeanFactory) {
        this.beanFactory = abstarcBeanFactory;
    }


    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
