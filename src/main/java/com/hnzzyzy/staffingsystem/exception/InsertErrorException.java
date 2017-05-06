package com.hnzzyzy.staffingsystem.exception;

/**
 * Created by dtkj_android on 2017/5/6.
 */
public class InsertErrorException extends RuntimeException {
    public InsertErrorException(String message) {
        super(message);
    }

    public InsertErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
