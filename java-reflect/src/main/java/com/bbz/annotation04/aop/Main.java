package com.bbz.annotation04.aop;

import java.util.Map;
import java.util.Properties;

/**
 * com.bbz.annotation04.aop
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
public class Main {

    public static void main(String[] args) {
        ServiceA serviceA = CGlibContainer.getInstance(ServiceA.class);
        serviceA.action();

        Map<String,String> env =  System.getenv();
        for (String name : env.keySet()) {
            System.out.println(env.get(name));
        }

        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("JAVA_HOME"));
    }
}
