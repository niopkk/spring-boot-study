package com.bbz.ioc.step05;


import com.bbz.ioc.step05.factory.AbstractBeanFactory;
import com.bbz.ioc.step05.factory.AutowireCapableBeanFactory;
import com.bbz.ioc.step05.factory.BeanFactory;
import com.bbz.ioc.step05.io.ResourceLoader;
import com.bbz.ioc.step05.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application-05.xml");


        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }


        HelloWorldService helloWordService = (HelloWorldService) beanFactory.getBean("helloWorldService");

        helloWordService.helloWorld();

    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application-05.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }


}
