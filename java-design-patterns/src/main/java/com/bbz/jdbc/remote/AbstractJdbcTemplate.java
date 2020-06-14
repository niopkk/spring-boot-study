package com.bbz.jdbc.remote;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractJdbcTemplate {

    protected JdbcTemplate jdbcTemplate;

    protected AbstractJdbcTemplate() {
        this.jdbcTemplate = new JdbcTemplate(getDataSource());
    }


    public abstract DataSource getDataSource();
}
