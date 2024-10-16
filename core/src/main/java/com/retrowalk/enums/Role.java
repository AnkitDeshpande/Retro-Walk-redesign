package com.retrowalk.enums;


import lombok.Getter;

/**
 * Role.
 */
@Getter
public enum Role {

    /**
     * PLATFORM_ADMIN.
     */
    PLATFORM_ADMIN("PLATFORM_ADMIN"),

    /**
     * ORGANIZATION_ADMIN.
     */
    SHOP_OWNER("SHOP_OWNER"),

    /**
     * SUPER_USER
     */
    SUPER_USER("SUPER_USER"),

    /**
     * BASIC_USER
     */
    BASIC_USER("BASIC_USER");

    /**
     * Value.
     * -- GETTER --
     * get value.
     */
    private final String value;

    /**
     * header name.
     *
     * @param val - value
     */
    Role(final String val) {
        this.value = val;
    }
}

