package com.gipplelake.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 要使用 Lambda 表达式，需要定义一个函数式接口，这样往往会让程序充斥着过量的仅为 Lambda 表达式服务的函数式接口。
 * 为了减少这样过量的函数式接口，Java 8 在 java.util.function 中增加了不少新的函数式通用接口。例如：
 * Predicate<T> ：将 T 作为输入，返回一个布尔值作为输出，该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（与、或、非）。
 * Function<T, R>：将 T 作为输入，返回 R 作为输出，他还包含了和其他函数组合的默认方法。
 * Consumer<T> ：将 T 作为输入，不返回任何内容，表示在单个参数上的操作。
 */
@FunctionalInterface
interface NumberInterface {
    boolean test(Integer i);
}

class TestPredicate {

    public static void main(String[] args) {
        System.out.println(Number.getNumbers((Integer i) -> i > 3));
        System.out.println(Number.getNumbersByPredicate((Integer i) -> i > 3));
    }
}

class Number {
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4);

    //使用自定义的函数式接口
    static List<Integer> getNumbers(NumberInterface numberInterface) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : NUMBERS) {
            if (numberInterface.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
   //使用原生的函数式接口
    static List<Integer> getNumbersByPredicate(Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : NUMBERS) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}