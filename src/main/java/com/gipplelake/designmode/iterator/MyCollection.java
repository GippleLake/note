package com.gipplelake.designmode.iterator;

/**
 * @author dengqg
 */
public class MyCollection implements Collection<String> {
    String[] collection = new String[3];

    int index = 0;

    public Iterator Iterator() {
        return new MyIterator(this);
    }

    public int getSize() {
        return collection.length;
    }

    public String get(int i) {
        return collection[i];
    }

    public void add(String s) {
        collection[index] = s;
        index++;
    }
}

class Test {
    public static void main(String[] args) {
        Collection<String> collection = new MyCollection();
        collection.add("qwe");
        collection.add("asdads");
        Iterator iterator = collection.Iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}