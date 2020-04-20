package com.bbz.ioc.step06;



import com.bbz.ioc.step06.beans.BeanDefinition;
import com.bbz.ioc.step06.beans.factory.AbstarcBeanFactory;
import com.bbz.ioc.step06.beans.factory.AutowiteCapableBeanFactory;
import com.bbz.ioc.step06.beans.io.LoaderResource;
import com.bbz.ioc.step06.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new LoaderResource());
        xmlBeanDefinitionReader.loadBeanDefinitions("application-06.xml");


        AbstarcBeanFactory beanFactory = new AutowiteCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }


        HelloWorldService helloWordService = (HelloWorldService) beanFactory.getBean("helloWorldService");

        helloWordService.helloWorld();

    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new LoaderResource());
        xmlBeanDefinitionReader.loadBeanDefinitions("application-06.xml");

        // 2.初始化BeanFactory并注册bean
        AbstarcBeanFactory beanFactory=new AutowiteCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
//        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }


}
