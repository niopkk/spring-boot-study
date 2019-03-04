package com.bbz.代理模式.JDK动态代理.service;

import com.bbz.代理模式.JDK动态代理.model.Project;

import org.springframework.stereotype.Component;

@Component
public class RedisUtil {


    public Project getProjectById(String id){
        if(id!=null && "123".equals(id)){

            return new Project(id,"假装从缓存中取出的项目");
        }else{
            return null;
        }
    }
}
