package com.bbz.jdbc.remote;


import java.sql.ResultSet;
import java.util.function.Consumer;

public interface IDataRead {


    /**
     * 读取数据
     * @param sql
     * @param callback
     */
    void read(String sql, Consumer<ResultSet> callback);
}
