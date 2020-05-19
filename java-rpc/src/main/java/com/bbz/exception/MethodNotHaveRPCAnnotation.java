package com.bbz.exception;

public class MethodNotHaveRPCAnnotation extends RuntimeException {

    public MethodNotHaveRPCAnnotation() {
    }

    public MethodNotHaveRPCAnnotation(String message) {
        super(message);
    }

    public MethodNotHaveRPCAnnotation(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotHaveRPCAnnotation(Throwable cause) {
        super(cause);
    }

    public MethodNotHaveRPCAnnotation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
