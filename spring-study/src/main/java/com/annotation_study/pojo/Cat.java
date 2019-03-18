package com.annotation_study.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat  implements InitializingBean,DisposableBean{
    @Override
    public void destroy() throws Exception {
        System.out.println("cat.........destory.........");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat..........atfterPropertiesSet............");
    }
}
