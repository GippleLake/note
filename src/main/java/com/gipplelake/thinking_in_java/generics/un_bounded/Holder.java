package com.gipplelake.thinking_in_java.generics.un_bounded;

/**
 * @author dengqg
 */
public class Holder<T> {
    private T value;
    public Holder(){}

    public Holder(T val){
        this.value = val;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}
