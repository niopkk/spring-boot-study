package com.demo1.config;

import com.demo1.BeanScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {


    @Bean
    public BeanScannerConfigurer beanScannerConfigurer() {
        return new BeanScannerConfigurer();
    }

}
