package com.bbz.ioc.step04;

import com.bbz.ioc.step04.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstracBeanDefinitionReader implements BeanDefinitionReader {


    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstracBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
