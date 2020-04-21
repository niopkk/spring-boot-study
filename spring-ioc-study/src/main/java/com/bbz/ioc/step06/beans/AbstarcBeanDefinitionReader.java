package com.bbz.ioc.step06.beans;

import com.bbz.ioc.step06.beans.io.LoaderResource;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstarcBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String,BeanDefinition> registry;


    private LoaderResource loaderResource;

    public AbstarcBeanDefinitionReader(LoaderResource loaderResource) {
        this.loaderResource = loaderResource;
        this.registry=new HashMap<>();
    }

    public LoaderResource getLoaderResource() {
        return loaderResource;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
