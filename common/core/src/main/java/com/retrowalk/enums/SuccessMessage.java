package com.retrowalk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    LOGIN_SUCCESS(200, "login.success"), MAIL_SUCCESS(200, "mail.sent.success"),
    LOGOUT_SUCCESS(200, "logout.success"),
    RESET_PASSWORD(200, "reset.password");

    /**
     * The code.
     */
    private final int code;

    /**
     * The message.
     */
    private final String message;
}
