package com.hnzzyzy.staffingsystem.exception;

/**
 * Created by dtkj_android on 2017/5/6.
 */
public class UserNameExitException extends RuntimeException {
    public UserNameExitException(String message) {
        super(message);
    }

    public UserNameExitException(String message, Throwable cause) {
        super(message, cause);
    }
}
