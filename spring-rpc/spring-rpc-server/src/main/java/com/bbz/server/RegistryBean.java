package com.bbz.server;

public interface RegistryBean {


    void register(Class<?> serviceInterface, Class<?> impl);
}
