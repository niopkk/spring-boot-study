package com.beanFactoryPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {MyBeanPostProcessor.class,MyBeanFactoryPostProcessor.class})
public class Config {

//    @Bean(initMethod = "initWelcomer")
//    public Welcomer welcomer() {
//        return new Welcomer();
//    }
//
//    @Bean
//    public BeanModifier beanModifier() {
//        return new BeanModifier();
//    }

//    @Bean
//    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
//        return new MyBeanFactoryPostProcessor();
//    }


    @Bean(initMethod = "init")
    public Person person() {
        Person person = new Person();
        person.setName("222222");
        return person;
    }

}
