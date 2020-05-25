package com.bbz.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JdbcTemplate {

    private JdbcTemplate() {
    }

    public static void update(String sql, Object[] params) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.clone(null, ps, connection);
        }
    }

    public static <T> T query(String sql, IRowMapper<T> rsh, Object... params) {

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            return rsh.mapping(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.clone(rs, st, connection);
        }
        return null;
    }
}
