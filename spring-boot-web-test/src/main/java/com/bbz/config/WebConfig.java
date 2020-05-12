package com.bbz.config;

import com.bbz.Student;
import com.bbz.UserIdArgumentResolver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * com.bbz.config
 * <p>
 * Created by tianxin2 on 2019/11/20
 */
@Configuration
@EnableConfigurationProperties({StudentProperties.class})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserIdArgumentResolver());
    }


    @Bean
    @ConditionalOnProperty(prefix = "student", name = {"enabled"}, havingValue = "true")
    public Student student() {

        return new Student("000002", "张三", 20);
    }


}
