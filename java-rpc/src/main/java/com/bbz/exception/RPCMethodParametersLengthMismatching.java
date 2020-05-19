package com.bbz.exception;

public class RPCMethodParametersLengthMismatching extends RuntimeException {
    public RPCMethodParametersLengthMismatching() {
    }

    public RPCMethodParametersLengthMismatching(String message) {
        super(message);
    }

    public RPCMethodParametersLengthMismatching(String message, Throwable cause) {
        super(message, cause);
    }

    public RPCMethodParametersLengthMismatching(Throwable cause) {
        super(cause);
    }

    public RPCMethodParametersLengthMismatching(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
