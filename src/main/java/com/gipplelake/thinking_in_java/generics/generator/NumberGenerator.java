package com.gipplelake.thinking_in_java.generics.generator;

/**
 * @author dengqg
 */
class NumberGenerator implements Generator<Integer> {
    private static int count = 0;

    public Integer next() {
        return count++;
    }
}
