package com.bbz.ioc.step04;

import com.bbz.ioc.step04.facotry.AutowireCapableBeanFactory;
import com.bbz.ioc.step04.facotry.BeanFactory;
import com.bbz.ioc.step04.io.ResourceLoader;
import com.bbz.ioc.step04.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("application.xml");


        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }


        HelloWordService helloWord = (HelloWordService) beanFactory.getBean("helloWordService");
        System.out.println(helloWord.getText());
        System.out.println(helloWord.getAge());

    }
}
