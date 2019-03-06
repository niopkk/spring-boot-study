package com.bbz.pojo;

import java.io.Serializable;

public class Respone implements Serializable {
    private static final long serialVersionUID = -6425130550372575157L;


    private Integer code;

    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
