package com.retrowalk.enums;

import lombok.Getter;

@Getter
public enum Database {

    /**
     * Default Database.
     */
    DEFAULT_DATABASE("retro_walk_master");

    /**
     * DB Name.
     */
    private final String dbName;

    Database(String dbName) {
        this.dbName = dbName;
    }

}
