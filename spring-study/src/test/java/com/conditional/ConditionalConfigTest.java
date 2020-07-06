package com.conditional;


import com.annotationconfig.config.Config;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalConfigTest {

//
//    @Autowired
//    private MagicBean magicBean;

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);

        MagicBean bean = applicationContext.getBean(MagicBean.class);
        bean.hello();

    }

}
