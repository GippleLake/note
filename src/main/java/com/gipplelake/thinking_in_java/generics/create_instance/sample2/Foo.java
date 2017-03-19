package com.gipplelake.thinking_in_java.generics.create_instance.sample2;

/**
 * @author dengqg
 */
public class Foo<T> {
    private T t;

     <F extends Factory<T>> Foo(F factory) {
        t = factory.create();
    }

    public static void main(String[] args) {
        //通过创建显式的工厂对象，获得了编译期检查
        new Foo<Integer>(new IntegerFactory());
        new Foo<Widget>(new Widget.Factory());

    }
}
