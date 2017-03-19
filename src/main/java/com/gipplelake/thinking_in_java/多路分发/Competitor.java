package com.gipplelake.thinking_in_java.多路分发;

/**
 * @author dengqg
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
