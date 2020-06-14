package com.bbz.jdbc.remote;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.function.Consumer;

public class OracleDataRead extends AbstractJdbcTemplate implements IDataRead {
    @Override
    public DataSource getDataSource() {
        return DataSourceBuilder.create().driverClassName("oracle.jdbc.drover.OracleDrover")
                .url("jdbc.oracle:thin:@1222")
                .build();
    }

    @Override
    public void read(String sql, Consumer<ResultSet> callback) {
        jdbcTemplate.query(sql, rs -> {
            callback.accept(rs);
        });
    }
}
