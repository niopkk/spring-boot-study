package com.bbz.ioc.step05;

import com.bbz.ioc.step05.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private Map<String, BeanDefinition> registry;

    public ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return this.registry;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
