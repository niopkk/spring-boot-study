package com.bbz.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class Pool {

    public String propertiesName = "connection-INFO.properties";

    private static Pool instance = null;

    /**
     * 最大连接数
     */
    protected int maxConnect = 100;

    /**
     * 保持连接数
     */
    protected int normalConnect = 0;

    /**
     * 驱动字符串
     */
    protected String driverName = null;

    /**
     * 驱动变量
     */
    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loderDrivers(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化所有从配置文件读取的成员变量
     *
     * @throws IOException
     */
    private void init() throws IOException {
        InputStream is = Pool.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    /**
     * 装载和注册所有jdbc驱动程序
     *
     * @param dri
     */
    protected void loderDrivers(String dri) {
        String driverClassName = dri;
        try {
            driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册jdbc驱动程序");
        } catch (Exception e) {
            System.out.println("无法注册jdbc驱动程序" + driverClassName + ",错误" + e);
        }
    }

    /**
     * 创建连接池
     *
     * @return
     */
    protected abstract void createPool();

    /**
     * 返回连接池Pool的的实例
     *
     * @return
     */
    public static synchronized Pool getInstance() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (null == instance) {
            instance.init();
            instance = (Pool) Class.forName("com.bbz.jdbc.Pool").newInstance();
        }
        return instance;
    }

    /**
     * 获取一个可用连接
     *
     * @return
     */
    protected abstract Connection getConnection();

    /**
     * 获得一个连接有时间限制
     *
     * @param time
     * @return
     */
    protected abstract Connection getConnection(long time);


    /**
     * 将连接对象返回给连接池
     *
     * @param con
     */
    protected abstract void freeConnection(Connection con);

    /**
     * 返回当前空闲连接数
     *
     * @return
     */
    public abstract int getnum();

    /**
     * 获取当前活动连接数
     *
     * @return
     */
    public abstract int getnumActive();

    /**
     * 撤销驱动
     */
    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销jdbc驱动程序" + driver.getClass().getName());
        } catch (Exception e) {
            System.out.println("无法撤销jdbc驱动程序" + driver.getClass().getName());
        }
    }
}
