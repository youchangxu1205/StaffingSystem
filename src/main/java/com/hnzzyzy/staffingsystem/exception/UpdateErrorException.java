package com.hnzzyzy.staffingsystem.exception;

/**
 * Created by dtkj_android on 2017/5/6.
 */
public class UpdateErrorException extends RuntimeException {
    public UpdateErrorException(String message) {
        super(message);
    }

    public UpdateErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
