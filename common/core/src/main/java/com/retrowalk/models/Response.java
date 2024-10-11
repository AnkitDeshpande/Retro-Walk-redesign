package com.retrowalk.models;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

/**
 * Universal builder class for creating responses.
 *
 * @param <T> - The type of the instance.
 */
@Slf4j
public class Response<T> {

    /**
     * The instance of the response type.
     */
    private T instance;

    /**
     * The condition for setting the instance.
     */
    private boolean ifCond = true;

    /**
     * The builder constructor.
     *
     * @param clazz - The class of type T.
     */
    public Response(final Class<T> clazz) {
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            log.error("Error instantiating class: {}", clazz.getName(), e);
        }
    }

    /**
     * Static method to start building a Response.
     *
     * @param clazz - The class of type T.
     * @param <T>   - The type of the response.
     * @return A new Response instance.
     */
    public static <T> Response<T> build(final Class<T> clazz) {
        return new Response<>(clazz);
    }

    /**
     * Adds a setter to modify the instance.
     *
     * @param setter - The setter function.
     * @return This Response instance for chaining.
     */
    public Response<T> with(final Consumer<T> setter) {
        if (ifCond) {
            setter.accept(instance);
        }
        return this;
    }

    /**
     * Gets the built instance.
     *
     * @return The instance of type T.
     */
    public T get() {
        return instance;
    }

    /**
     * Sets the condition for the with method.
     *
     * @param condition - The condition supplier.
     * @return This Response instance for chaining.
     */
    public Response<T> ifs(final BooleanSupplier condition) {
        this.ifCond = condition.getAsBoolean();
        return this;
    }

    /**
     * Resets the condition for the with method.
     *
     * @return This Response instance for chaining.
     */
    public Response<T> endIf() {
        this.ifCond = true;
        return this;
    }
}
