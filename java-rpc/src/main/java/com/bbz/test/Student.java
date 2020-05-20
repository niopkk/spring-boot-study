package com.bbz.test;


import com.bbz.annotation.RPCmethod;
import com.bbz.annotation.RpcClass;

@RpcClass
public class Student {

    private String name;

    @RPCmethod(remoteName = "getStudentName")
    public String getName() {
        return name == null ? "小明" : name;
    }

    @RPCmethod(remoteName = "setStudentName")
    public Student setName(String name) {
        this.name = name;
        return this;
    }


}
