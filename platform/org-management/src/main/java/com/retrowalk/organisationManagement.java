package com.retrowalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class organisationManagement {
    /**
     * Entry method for application.
     *
     * @param args - The args
     */
    public static void main(final String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(organisationManagement.class, args);

    }

}
