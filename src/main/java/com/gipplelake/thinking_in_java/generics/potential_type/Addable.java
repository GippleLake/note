package com.gipplelake.thinking_in_java.generics.potential_type;


import com.gipplelake.thinking_in_java.generics.generator.Coffee;
import com.gipplelake.thinking_in_java.generics.generator.Generator;
import com.gipplelake.thinking_in_java.generics.generator.Latte;
import com.gipplelake.thinking_in_java.generics.generator.Mocha;

import java.util.*;

/**
 * @author dengqg
 * 由于java并没有潜在类型机制,而我们需要像类型机制这样的东西去编写能够跨类边界应用的代码,
 * 所以如果我能手动编写潜在类型机制所需要的隐式接口,就能解决这样的问题.
 *适配器模式就是解决方案
 */

interface Addable<T> {
    void add(T t);
}


//类生成器
 class Fill2 {

    //利用反射来生成
     static <T> void fill(Addable<T> addable,Class<? extends T> classToken,int size){
        for(int i = 0; i < size ; i++){
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size){
        for(int i = 0;i < size;i++)
            addable.add(generator.next());
    }
}
//适配器1
class AddableCollectionAdapter<T> implements Addable<T>{

    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }

    public void add(T t) {
        c.add(t);
    }
}

//适配器2，使用泛型方法，这是产生更优雅的代码的一种惯用技巧
class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

//使用继承来创建这个适配器3
class AddableSimpleQueue<T> implements Addable<T>,Iterable<T>{

    Collection<T> collection =  new ArrayList<T>();
    public void add(T item){
        collection.add(item);
    }

    public Iterator<T> iterator() {
        return collection.iterator();
    }

}



 class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<Coffee>();

        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);

        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);

        for(Coffee c : carrier)
            System.out.println(c);

        System.out.println("-----------------------------------------------");

        AddableSimpleQueue<Coffee> coffeeQueue =  new AddableSimpleQueue<Coffee>();

        Fill2.fill(coffeeQueue, Mocha.class, 4);

        Fill2.fill(coffeeQueue, Latte.class, 1);

        for(Coffee c : coffeeQueue)
            System.out.println(c);
    }
}
