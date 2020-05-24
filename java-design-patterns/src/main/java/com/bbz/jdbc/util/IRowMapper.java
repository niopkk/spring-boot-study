package com.bbz.jdbc.util;

import java.sql.ResultSet;
import java.util.List;

public interface IRowMapper<T> {
    List<T> mapping(ResultSet rs) throws Exception;
}
