package com.annotation_study.config;

import com.annotation_study.condition.LiunxCondition;
import com.annotation_study.condition.MyImportBeanDefinitionRegistrar;
import com.annotation_study.condition.MyImportSelector;
import com.annotation_study.condition.WindowsCondition;
import com.annotation_study.pojo.Person;
import com.annotation_study.pojo.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.ReflectionUtils;

@Configuration
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainPersonConfig {


    @Bean
    public Person person() {
        return new Person("张三", 20);
    }


    @Conditional(WindowsCondition.class)
    @Bean("windows")
    public Person windowsPerson() {
        return new Person("windows", 30);
    }

    @Conditional(LiunxCondition.class)
    @Bean("liunx")
    public Person liunxPerson() {
        return new Person("liunx", 30);
    }
}
