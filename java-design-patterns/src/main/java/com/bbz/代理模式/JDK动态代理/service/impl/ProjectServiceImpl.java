package com.bbz.代理模式.JDK动态代理.service.impl;

import com.bbz.代理模式.JDK动态代理.model.Project;
import com.bbz.代理模式.JDK动态代理.service.ProjectService;

import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public Project getProjectById(String id) {
        return new Project("123","假装从数据库中取出的项目");
    }
}
