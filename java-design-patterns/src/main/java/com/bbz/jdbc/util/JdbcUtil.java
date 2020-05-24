package com.bbz.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static Properties p = null;

    private JdbcUtil() {
    }

    static {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("application.yaml");
            p = new Properties();
            p.load(inputStream);
            Class.forName(p.getProperty("driveClassName"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clone(ResultSet rs, Statement st, Connection connection) {

        try {
            if (null != rs) {
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != st) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != connection) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }

        }

    }
}
