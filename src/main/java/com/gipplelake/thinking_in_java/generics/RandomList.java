package com.gipplelake.thinking_in_java.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dengqg
 *         随机的从一个持有特定类型的容器中读取元素
 */
public class RandomList<T> {
    private Random random = new Random();
    private List<T> list = new ArrayList<T>();

    public void add(T item) {
        list.add(item);
    }

    T rand() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomList<String> list = new RandomList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (int i = 0; i < 10; i++) {
            System.out.println(list.rand());
        }

    }
}


