package com.bbz.代理模式.JDK动态代理.controller;

import com.bbz.代理模式.JDK动态代理.model.Project;
import com.bbz.代理模式.JDK动态代理.proxy.DataBaseProxyHandler;
import com.bbz.代理模式.JDK动态代理.proxy.ProxyInterface;
import com.bbz.代理模式.JDK动态代理.service.ProjectService;
import com.bbz.代理模式.JDK动态代理.service.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectContoller {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private RedisUtil redisUtil;

    public Project test(String id) {
        return new DataBaseProxyHandler<ProjectService>(redisUtil).proxy(projectService, new ProxyInterface() {

            @Override
            public Object doEnd(Object returnObj, Object o, Object[] param) {
                System.out.println(returnObj.toString());
                System.out.println("----");
                System.out.println(o.toString());
                System.out.println("-----");
                System.out.println(param.toString());
                return null;
            }
        }).getProjectById("123");
    }
}
