package com.bbz.exception;

public class RPCServiceNotRegister extends RuntimeException {

    public RPCServiceNotRegister() {
    }

    public RPCServiceNotRegister(String message) {
        super(message);
    }

    public RPCServiceNotRegister(String message, Throwable cause) {
        super(message, cause);
    }

    public RPCServiceNotRegister(Throwable cause) {
        super(cause);
    }

    public RPCServiceNotRegister(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
