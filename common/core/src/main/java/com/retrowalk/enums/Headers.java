package com.retrowalk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Headers {

    TENANT_ID("X-Tenant-Id");

    private final String value;
}
