package com.bbz.spring.formework.beans.support;

import com.bbz.spring.formework.annotation.Autowired;
import com.bbz.spring.formework.beans.config.BeanDefinition;
import com.bbz.util.Strings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BeandDefinitionReader {

    private List<String> registyBeanClasses = new ArrayList<>();

    private Properties config = new Properties();

    private final String SCAN_PACKAGE = "scanPackage";


    private String[] configLocations;

    public BeandDefinitionReader(String... locations) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath", ""));
        try {
            config.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {

        URL url = this.getClass().getClassLoader().getResource("./" + scanPackage.replaceAll("\\.", "/"));
        File fileClassPath = new File(url.getFile());

        for (File file : fileClassPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                registyBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig() {
        return this.config;
    }

    public List<BeanDefinition> loadBeanDefinitions() {

        List<BeanDefinition> result = new ArrayList<>();

        try {
            for (String className : registyBeanClasses) {

                if (Strings.equals("com.bbz.spring.formework.servlet.DispatcherServlet", className)) {
                    continue;
                }
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }
                result.add(doCreateBeanDefinition(Strings.uncapitalize(beanClass.getSimpleName()), beanClass.getName()));
                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i : interfaces) {
                    result.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private  BeanDefinition doCreateBeanDefinition(String factoryBeanName, String beanClassName) {
        BeanDefinition beanDefinition = new BeanDefinition();
        //类的全限定名称,com.bbz.Test
        beanDefinition.setBeanClassName(beanClassName);
        //类的名称:test
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }
}
