package com.gipplelake.thinking_in_java.generics.generator;

/**
 * 对象随机生成器
 */
public interface Generator<T> {
    T next();
}
