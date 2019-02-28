package com.netty.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public abstract class Packet {


    /**
     * 定义版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    /**
     * 指令
     *
     * @return
     */
    @JSONField(deserialize = false, serialize = false)
    public abstract Byte getCommand();

}
