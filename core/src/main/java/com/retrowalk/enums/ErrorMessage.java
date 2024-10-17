package com.retrowalk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    INTERNAL_SERVER_ERROR(500, "something.went.wrong"),
    USER_NOT_FOUND(404, "error.user.not.found"),
    INCORRECT_OLD_PASSWORD(400, "error.incorrect.old.password"),
    PASSWORDS_DO_NOT_MATCH(400, "error.passwords.do.not.match"),
    TOKEN_REQUIRED(404, "error.token.required"),
    TOKEN_NOT_FOUND(404, "error.token.not_found");

    /**
     * The code.
     */
    private final int code;

    /**
     * The message.
     */
    private final String message;
}
