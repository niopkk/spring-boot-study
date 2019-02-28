package com.bbz.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.bbz.core") //将serverice 注入spring管理,jda无法注入需要下面两个注解才能将jpa注入spring
@EnableJpaRepositories(basePackages = "com.bbz.core.repository")
@EntityScan(basePackages = "com.bbz.core.entity")
public class CoreAutoConfiguration {
}
