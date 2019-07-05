package com.bbz.consumer;

/**
 * com.bbz.consumer
 * <p>
 * Created by tianxin2 on 2019-07-04
 */
public class MyException extends RuntimeException {

    private String code;

    private String message;

    public MyException(String message, String code) {
        super(message);
        this.code = code;
    }
}
