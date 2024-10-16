package com.retrowalk.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RetrowalkException extends RuntimeException {

    /**
     * The exception code.
     */
    private int code;

    /**
     * The exception message.
     */
    private String message;

    public RetrowalkException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RetrowalkException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public RetrowalkException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public RetrowalkException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public RetrowalkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
