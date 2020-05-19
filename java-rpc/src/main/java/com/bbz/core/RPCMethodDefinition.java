package com.bbz.core;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Method;


public class RPCMethodDefinition {

    //要通过反射调用的类
    private Class klass;

    //要通过反射执行方法的对象
    private Object object;

    //要执行的方法
    private Method method;

    public Class getKlass() {
        return klass;
    }

    public RPCMethodDefinition setKlass(Class klass) {
        this.klass = klass;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public RPCMethodDefinition setObject(Object object) {
        this.object = object;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public RPCMethodDefinition setMethod(Method method) {
        this.method = method;
        return this;
    }
}
