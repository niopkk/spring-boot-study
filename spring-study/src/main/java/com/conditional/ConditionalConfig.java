package com.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConditionalConfig {


    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
