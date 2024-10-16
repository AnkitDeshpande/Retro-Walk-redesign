package com.retrowalk.enums;

import lombok.Getter;

@Getter
public enum MailConfigEnum {

    HOST("smtp.gmail.com"),
    PORT("587"),
    USERNAME("dankit@agsft.com"),
    PASSWORD("basgcuyoocwdxste"),
    PROTOCOL("smtp"),
    SMTP_AUTH("true"),
    STARTTLS_ENABLE("true"),
    MAIL_DEBUG("true");

    private final String value;

    MailConfigEnum(String value) {
        this.value = value;
    }

}
