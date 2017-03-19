package com.gipplelake.thinking_in_java.generics.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author dengqg
 *         使用生成器填充一个容器变得很容易
 */
public class Generators {
    private static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    private static <T> ArrayList<T> fill(ArrayList<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }


    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
        Collection<Integer> numbers = fill(new HashSet<Integer>(), new NumberGenerator(), 10);
        System.out.println(numbers);
    }

}
