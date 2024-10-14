package com.retrowalk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    INTERNAL_SERVER_ERROR(500, "something.went.wrong");

    /**
     * The code.
     */
    private final int code;

    /**
     * The message.
     */
    private final String message;
}
