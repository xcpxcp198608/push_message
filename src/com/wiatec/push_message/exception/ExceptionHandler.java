package com.wiatec.push_message.exception;

/**
 * Created by xuchengpeng on 13/06/2017.
 */
public class ExceptionHandler extends RuntimeException {

    public ExceptionHandler() {
        super();
    }

    public ExceptionHandler(String message) {
        super(message);
    }

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
