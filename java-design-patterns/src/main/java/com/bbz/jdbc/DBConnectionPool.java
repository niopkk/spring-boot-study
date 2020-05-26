package com.bbz.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public final class DBConnectionPool extends Pool {
    /**
     * 正在使用的连接数
     */
    private int checkOut;

    /**
     * 存放产生连接对象的容器
     */
    private Vector<Connection> freeConnections = new Vector<>();

    /**
     * 密码
     */
    private String passWord = null;

    /**
     * 连接字符串
     */
    private String url = null;

    /**
     * 用户名称
     */
    private String userName = null;

    /**
     * 空闲连接数
     */
    private static int num = 0;

    /**
     * 连接活跃数
     */
    private static int numActive = 0;

    /**
     * 连接池实例变量
     */
    private static DBConnectionPool pool = null;


    public static DBConnectionPool getInstance() {
        if (null == pool) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                if (null != c) {
                    freeConnections.addElement(c);
                    num++;//记录中连接数
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.passWord = p.getProperty("passWord");
        this.url = p.getProperty("url");
        this.userName = p.getProperty("userName");
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    /**
     * 创建一个新连接
     *
     * @return
     */
    private Connection newConnection() {
        Connection con = null;
        try {
            if (null == userName) {
                con = DriverManager.getConnection(url);
            } else {
                con = DriverManager.getConnection(url, userName, passWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return con;
    }

    /**
     * 返回当前空闲数
     *
     * @return
     */
    @Override
    public int getnum() {
        return num;
    }

    /**
     * 返回当前活跃数
     *
     * @return
     */
    @Override
    public int getnumActive() {
        return numActive;
    }

    /**
     * 获取一个连接
     *
     * @return
     */
    @Override
    public Connection getConnection() {
        Connection con = null;

        if (freeConnections.size() > 0) {
            num--;
            con = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (con.isClosed()) {
                    //删除无效连接
                    con = getConnection();
                }
            } catch (SQLException e) {
                con = getConnection();
            }
        } else if (maxConnect == 0 || checkOut < maxConnect) {
            con = newConnection();
        }
        if (null != con) {
            //当前连接数
            checkOut++;
        }
        numActive++;
        return con;
    }

    @Override
    public Connection getConnection(long timeout) {
        long startTime = System.currentTimeMillis();
        Connection con;
        while (null == (con = getConnection())) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {

            }
        }
        if ((System.currentTimeMillis() - startTime) > timeout) {
            return null;
        }
        return con;
    }

    @Override
    public void freeConnection(Connection con) {
        freeConnections.addElement(con);
        num++;
        checkOut--;
        numActive++;
        notifyAll();
    }

    @Override
    public synchronized void release() {
        try {
            Enumeration<Connection> allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection con = allConnections.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (null != pool) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
}
