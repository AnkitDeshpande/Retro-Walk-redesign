package com.retrowalk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Database {

    /**
     * Default Database.
     */
    DEFAULT_DATABASE("retro_walk_master");

    /**
     * DB Name.
     */
    private String dbName;

    Database(String dbName) {
        this.dbName = dbName;
    }
}
