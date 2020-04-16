package com.day_02_spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@PropertySource(value = "classpath:application.properties")
public class JdbcConfig {

    @Value("${jdbc.name}")
    private String name;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.password}")
    private String password;

    @Bean(value = "dataSource")
    public DataSource createDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(name);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(value = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
