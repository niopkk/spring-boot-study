package com.bbz.exception;

public class RPCServiceObjectNotLoad extends RuntimeException {
    public RPCServiceObjectNotLoad() {
    }

    public RPCServiceObjectNotLoad(String message) {
        super(message);
    }

    public RPCServiceObjectNotLoad(String message, Throwable cause) {
        super(message, cause);
    }

    public RPCServiceObjectNotLoad(Throwable cause) {
        super(cause);
    }

    public RPCServiceObjectNotLoad(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
