package com.bbz.proxy;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

public class RpcProxyFacotry {


    private Class<?> classType;

    private InetSocketAddress addr;


    public <T> T proxy(final Class<?> classType, final InetSocketAddress addr) {
        this.classType = classType;
        this.addr = addr;
//      ClassLoader loader 定义代理生成的类的加载器，可以自定义类加载器，也可以复用当前Class的类加载器
//      定义代理对象需要实现的接口(必须是接口)
        return (T) Proxy.newProxyInstance(
                this.classType.getClassLoader()
                , new Class<?>[]{this.classType}
                , new RpcProxy(classType, addr)
        );
    }


}
