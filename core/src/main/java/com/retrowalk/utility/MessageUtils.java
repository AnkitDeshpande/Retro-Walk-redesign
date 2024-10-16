package com.retrowalk.utility;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtils {

    /**
     * Get the message from properties file based on current local.
     *
     * @param message - The message key
     * @param args    -    The argument list
     * @return String - The message
     */
    public String getMessage(final String message, final Object[] args) {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages/we_messages");
        source.setUseCodeAsDefaultMessage(true);
        Locale locale = LocaleContextHolder.getLocale();
        return source.getMessage(message, args, locale);
    }
}