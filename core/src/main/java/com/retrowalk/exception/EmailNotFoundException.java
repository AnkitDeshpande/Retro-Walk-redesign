package com.retrowalk.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception thrown when an email address given could not be found.
 */
@Getter
@Setter
public class EmailNotFoundException extends RuntimeException {

    /**
     * The exception code.
     */
    private int code;

    /**
     * The exception message.
     */
    private String message;

    public EmailNotFoundException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public EmailNotFoundException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public EmailNotFoundException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public EmailNotFoundException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public EmailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }
}
