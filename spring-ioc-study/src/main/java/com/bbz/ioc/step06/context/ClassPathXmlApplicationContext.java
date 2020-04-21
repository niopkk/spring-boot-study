package com.bbz.ioc.step06.context;


import com.bbz.ioc.step06.beans.BeanDefinition;
import com.bbz.ioc.step06.beans.factory.AbstarcBeanFactory;
import com.bbz.ioc.step06.beans.factory.AutowiteCapableBeanFactory;
import com.bbz.ioc.step06.beans.io.LoaderResource;
import com.bbz.ioc.step06.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstarcApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowiteCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstarcBeanFactory abstarcBeanFactory) throws Exception {
        super(abstarcBeanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new LoaderResource());
        xmlBeanDefinitionReader.loadBeanDefinitions(this.configLocation);

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

    }
}
