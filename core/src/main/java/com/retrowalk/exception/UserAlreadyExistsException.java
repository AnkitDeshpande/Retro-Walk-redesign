package com.retrowalk.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception thrown at user registration if an existing user already exists
 * with the given information.
 */
@Getter
@Setter
public class UserAlreadyExistsException extends RuntimeException {
    /**
     * The exception code.
     */
    private int code;

    /**
     * The exception message.
     */
    private String message;

    public UserAlreadyExistsException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public UserAlreadyExistsException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public UserAlreadyExistsException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public UserAlreadyExistsException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public UserAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }
}
