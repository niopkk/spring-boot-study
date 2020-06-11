package com.bbz.resource;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class MainTest {


    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {


        //默认为全路径名
        new MainTest().getResources("1.txt");

        //fileName：
        //  ClassLoader:根目录为 target/classes/
        // fileName 前面加 / 报错 原因：改变了 / 根目录 绝对路径
        new MainTest().getClassLoaderResources("/com/bbz/resource/2.txt");


    }

    public void getResources(String fileName) throws IOException {
        //fileName：
        //  1、前面加 / 表示绝对路径,在 /(根)目录下查找文件。如-> /1.txt
        //  2、没加 / 或者 ./  表示相对路径在当前类路径下面查询文件，如->./com/bbz/resource/1.txt
        System.out.println(this.getClass().getResource(fileName).getPath());
        URL url =this.getClass().getResource(fileName);
        properties.load(url.openStream());

        System.out.println(properties.getProperty("key"));
    }
    public void getClassLoaderResources(String fileName) throws IOException {
        //getClassLoader() 表示在 /(根) 目录下查找文件,路径如——> /1.txt
        //如果文件在包下面还要自己去加上包的路径，路径如——> com/bbz/resource/1.txt
        System.out.println(this.getClass().getClassLoader().getResource(fileName).getPath());
        URL url =this.getClass().getClassLoader().getResource(fileName);
        properties.load(url.openStream());

        System.out.println(properties.getProperty("key"));
    }
}
