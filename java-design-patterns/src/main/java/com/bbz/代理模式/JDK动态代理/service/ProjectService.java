package com.bbz.代理模式.JDK动态代理.service;


import com.bbz.代理模式.JDK动态代理.model.Project;

public interface ProjectService {

    Project getProjectById(String id);

    Project getProjectByName(String name);
}
