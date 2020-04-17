package com.bbz.ioc.step05;

import com.bbz.ioc.step05.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstracBeanDefinitionReader implements BeanDefinitionReader {


    private Map<String, BeanDefinition> registy;

    public ResourceLoader resourceLoader;

    public AbstracBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registy = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegisty() {
        return registy;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
