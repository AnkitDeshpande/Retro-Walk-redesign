package com.retrowalk.enums;


public enum Database {

    DEFAULT_DATABASE("DATABASE_NAME");

    private String name;

    Database(String name) {
        this.name = name;
    }
}
