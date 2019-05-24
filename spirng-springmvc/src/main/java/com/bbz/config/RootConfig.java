package com.bbz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * com.bbz.config
 * <p>
 * Created by tianxin2 on 2019-05-22
 */
@Configuration
@ComponentScan(basePackages = {"com.bbz"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {


}
