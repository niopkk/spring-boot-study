package com.bbz.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    protected static Logger log = LoggerFactory.getLogger(BaseController.class);

    public static <T> ResultView okResult(String msg) {
        return okResult(msg, true);
    }

    public static <T> ResultView okResult(String msg, T data) {
        return okResult(msg, data, 0);
    }

    public static <T> ResultView okResult(String msg, T data, long total) {
        return okResult(1, msg, data, total);
    }

    public static <T> ResultView okResult(Integer code, String msg, T data, long total) {
        return new ResultView(code, msg, data, total);
    }


    public static <T> ResultView errorResult(String msg) {
        return errorResult(msg, false);
    }

    public static <T> ResultView errorResult(String msg, T data) {
        return errorResult(-1, msg, data);
    }

    public static <T> ResultView errorResult(Integer code, String msg, T data) {
        return new ResultView(code, msg, data, 0);
    }
}
