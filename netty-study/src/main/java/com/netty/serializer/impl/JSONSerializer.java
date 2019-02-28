package com.netty.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.netty.serializer.Serializer;
import com.netty.serializer.SerializerAlogrithm;


public class JSONSerializer implements Serializer {


    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    public byte[] serializer(Object object) {
        return JSON.toJSONBytes(object);
    }

    public <T> T deserialize(Class<T> t, byte[] bytes) {
        return JSON.parseObject(bytes, t);
    }
}
