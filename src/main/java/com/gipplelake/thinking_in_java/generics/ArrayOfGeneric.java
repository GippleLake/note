package com.gipplelake.thinking_in_java.generics;

import java.lang.reflect.Array;

/**
 * 一般使用泛型容器替换泛型数组，如果非要泛型数组，可采取以下方式
 *
 * @author dengqg
 */
public class ArrayOfGeneric<T> {
    private T[] array;
    private T[] array2;

    @SuppressWarnings("unchecked")
    public ArrayOfGeneric(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
        array2 = (T[]) new Object[size];

    }


    public T[] rep() {
        return array;
    }

    public T[] rep2() {
        return array2;
    }

    public static void main(String[] args) {
        ArrayOfGeneric<Integer> arrayOfGeneric = new ArrayOfGeneric<Integer>(Integer.class, 20);
        Integer[] result = arrayOfGeneric.rep();
        //java.lang.ClassCastException 由于擦除，数组的运行时类型只能是Object[],只有指定Class type才能得到确切的类型T[]
        Integer[] result2 = arrayOfGeneric.rep2();
    }
}
