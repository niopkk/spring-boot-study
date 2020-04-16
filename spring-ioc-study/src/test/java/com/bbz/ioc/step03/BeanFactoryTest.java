package com.bbz.ioc.step03;

import com.bbz.ioc.step03.facotry.AutowrieCapableBeanFactory;
import com.bbz.ioc.step03.facotry.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //1、初始化bean工厂
        BeanFactory beanFactory = new AutowrieCapableBeanFactory();

        //2、定义bean的信息
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.bbz.ioc.step03.HelloWordService");

        //3、设置属性
        PropertyValues propertyValues = new PropertyValues();

        propertyValues.addPropertyValue(
                new PropertyValue("text", "你好"),
                new PropertyValue("age", 23));

        beanDefinition.setPropertyValues(propertyValues);

        //4、生成bean
        beanFactory.registerBeanDefinition("helloWordService", beanDefinition);

        //5、获取bean
        HelloWordService helloWordService = (HelloWordService) beanFactory.getBean("helloWordService");
//        helloWordService.helloWorld();
        System.out.println(helloWordService.getAge());
        System.out.println(helloWordService.getText());
    }
}
