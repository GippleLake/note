package com.gipplelake.thinking_in_java.generics.generator;

/**
 * @author dengqg
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

