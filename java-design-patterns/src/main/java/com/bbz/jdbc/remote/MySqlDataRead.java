package com.bbz.jdbc.remote;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.function.Consumer;

public class MySqlDataRead extends AbstractJdbcTemplate implements IDataRead {



    @Override
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Override
    public void read(String sql, Consumer<ResultSet> callback) {
        jdbcTemplate.query(sql, rs -> {
            callback.accept(rs);
        });
    }
}
