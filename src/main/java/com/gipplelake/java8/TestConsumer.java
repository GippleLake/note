package com.gipplelake.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author dengqg
 */
public class TestConsumer {

    private static List<String> STRINGS = new ArrayList<String>() {{
        add("one");
        add("two");
        add("three");
    }};

    static void delete(Consumer<List<String>> consumer) {
        consumer.accept(STRINGS);
    }

    public static void main(String[] args) {
        Consumer<List<String>> removeFirst = ((List<String> s) -> s.remove(0));
        delete(removeFirst.andThen(removeFirst));
        System.out.println(STRINGS);

    }

}


