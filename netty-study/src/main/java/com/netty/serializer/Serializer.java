package com.netty.serializer;

import com.netty.serializer.impl.JSONSerializer;

public interface Serializer {


    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转为二进制
     *
     * @param object
     * @return
     */
    byte[] serializer(Object object);

    /**
     * 二进制转为java 对象
     *
     * @param t
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> t, byte[] bytes);
}
