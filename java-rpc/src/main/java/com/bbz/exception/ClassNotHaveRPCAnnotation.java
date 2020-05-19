package com.bbz.exception;

public class ClassNotHaveRPCAnnotation extends RuntimeException {

    public ClassNotHaveRPCAnnotation() {
    }

    public ClassNotHaveRPCAnnotation(String message) {
        super(message);
    }

    public ClassNotHaveRPCAnnotation(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNotHaveRPCAnnotation(Throwable cause) {
        super(cause);
    }

    public ClassNotHaveRPCAnnotation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
