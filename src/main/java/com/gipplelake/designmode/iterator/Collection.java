package com.gipplelake.designmode.iterator;

/**
 * @author dengqg
 */
public interface Collection<E> {


    Iterator Iterator();

    int getSize();

    E get(int i);

    void add(E e);
}
