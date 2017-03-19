package com.gipplelake.designmode.iterator;

/**
 * @author dengqg
 */
public class MyIterator implements Iterator {
    Collection collection;
    int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    public Object next() {
        if (pos < collection.getSize() - 1) {
            pos++;
        }
        return collection.get(pos);
    }

    public Object preview() {
        if (pos > 0) {
            pos--;
        }
        return collection.get(pos);
    }

    public boolean hasNext() {
        return pos < collection.getSize()-1;
    }
}
