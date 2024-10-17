package com.retrowalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Work excellence auth application.
 */
@SpringBootApplication
@ComponentScan(value = "com.retrowalk.*")
public class AuthenticationApplication {


    /**
     * Entry method for application.
     *
     * @param args - The args
     */
    public static void main(final String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AuthenticationApplication.class, args);

    }

}
