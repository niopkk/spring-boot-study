package com.spring源码揭秘;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * com.spring源码揭秘
 * <p>
 * Created by tianxin2 on 2019/12/24
 */
@SuppressWarnings("deprecation")
public class MyTestBeanTest {

    @Test
    public void testSimpleLoad() throws IOException {

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("mytestbean.xml"));

        System.out.println("ddd");
//        ClassPathXmlApplicationContext

        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
//
        System.out.println(myTestBean.getTestStr());
//        assertEquals("testStr", myTestBean.getTestStr());

//        Resource resource = new ClassPathResource("test.txt");
//
//        final InputStream inputStream = resource.getInputStream();
//
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String str;
//        while ((str = bufferedReader.readLine()) != null) {
//            System.out.println(str);
//        }


    }

}
