package com.gipplelake.thinking_in_java.generics.create_instance.sample2;

/**
 * @author dengqg
 */
class IntegerFactory implements Factory<Integer> {

    public Integer create() {
        return 0;
    }
}
