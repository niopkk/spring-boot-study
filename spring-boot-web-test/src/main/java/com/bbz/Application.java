package com.bbz;

import com.bbz.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/11/20
 */
@SpringBootApplication
@Controller
public class Application {


    @Autowired
    private StudentProperties properties;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment env;



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }




    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String list(Subject subject, User user) {
//        Student bean = applicationContext.getBean(Student.class);

//        if (null != bean) {
//            return properties.getName() + ";" + bean.getName();
//        }
        String property = env.getProperty("spring.profiles.active", "default");

//        System.out.println(property);

        Welcomer welcomer = applicationContext.getBean(Welcomer.class);

        System.out.println(welcomer.getWelcomeText());

        return properties.getName();
    }
}
