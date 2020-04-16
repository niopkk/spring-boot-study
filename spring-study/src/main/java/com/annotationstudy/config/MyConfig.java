package com.annotationstudy.config;

import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, ImportMySelect.class})
public class MyConfig {


    @Conditional({WindowsConditional.class})
    @Bean
    public Person person01() {
        return new Person("Windows", 23);
    }

    @Conditional({LiunxConditional.class})
    @Bean
    public Person person02() {
        return new Person("liunx", 32);
    }
}
