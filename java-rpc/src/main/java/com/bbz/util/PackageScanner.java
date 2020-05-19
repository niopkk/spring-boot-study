package com.bbz.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public abstract class PackageScanner {



    private ClassLoader classLoader;

    public PackageScanner() {
    }

    //实参为一个类，则得到其所在包的路径
    public void packageScanner(Class<?> clazz) {
        this.packageScanner(clazz.getPackage().getName());
    }

    //实参为包路径，例如com.mec
    public void packageScanner(String rootPackage) {
        String rootPath = rootPackage.replace(".", "/");
        this.classLoader = Thread.currentThread().getContextClassLoader();

        try {
            //通过这种可以得到包录路径下所有的类，包括jar包里
            Enumeration urls = this.classLoader.getResources(rootPath);

            while(urls.hasMoreElements()) {
                URL url = (URL)urls.nextElement();
                String jarProtocol = url.getProtocol();
                //普通类的jarProtocol为file，jar包里的类为jar
                if (jarProtocol.equals("file")) {
                    try {
                        File file = new File(url.toURI());
                        this.scanPackage(file.getAbsolutePath(), rootPackage);
                    } catch (URISyntaxException var7) {
                        var7.printStackTrace();
                    }
                } else if (jarProtocol.equals("jar")) {
                    this.scanPackage(url);
                }
            }
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    //这是抛给外部来处理遍历到到的类的方法
    public abstract void dealClass(Class<?> var1);

    //处理不是jar包里的类，利用递归遍历的方法全部过一遍
    private void scanPackage(String path, String packageName) {
        File curFile = new File(path);
        if (curFile.exists()) {
            File[] files = curFile.listFiles();
            File[] var5 = files;
            int var6 = files.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                File file = var5[var7];
                if (file.isDirectory()) {
                    this.scanPackage(file.getAbsolutePath(), packageName + "." + file.getName());
                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    String fileName = file.getName();
                    int dotInde = fileName.indexOf(".class");
                    fileName = fileName.substring(0, dotInde);
                    String className = packageName + "." + fileName;

                    try {
                        Class<?> klass = Class.forName(className);
                        this.dealClass(klass);
                    } catch (ClassNotFoundException var13) {
                        var13.printStackTrace();
                    }
                }
            }

        }
    }

    //扫描jar包里的类
    private void scanPackage(URL url) {
        try {
            JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
            JarFile jarFile = jarURLConnection.getJarFile();
            Enumeration jarEntries = jarFile.entries();

            while(jarEntries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry)jarEntries.nextElement();
                if (!jarEntry.isDirectory() && jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName();
                    int dotIndex = className.indexOf(".class");
                    className = className.substring(0, dotIndex).replace("/", ".");
                    if (className.startsWith("com.bbz")) {
                        try {
                            Class<?> klass = Class.forName(className);
                            this.dealClass(klass);
                        } catch (ClassNotFoundException var9) {
                            var9.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException var10) {
            var10.printStackTrace();
        }

    }

}
