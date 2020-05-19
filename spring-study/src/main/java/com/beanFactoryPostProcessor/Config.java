package com.beanFactoryPostProcessor;

import com.beanFactoryPostProcessor.support.BeanModifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(initMethod = "initWelcomer")
    public Welcomer welcomer() {
        return new Welcomer();
    }

    @Bean
    public BeanModifier beanModifier() {
        return new BeanModifier();
    }
}
