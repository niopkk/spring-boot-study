package com.bbz.exception;

public class RPCProxyReadOutTimeException extends RuntimeException {
    public RPCProxyReadOutTimeException() {
    }

    public RPCProxyReadOutTimeException(String message) {
        super(message);
    }

    public RPCProxyReadOutTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RPCProxyReadOutTimeException(Throwable cause) {
        super(cause);
    }

    public RPCProxyReadOutTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
