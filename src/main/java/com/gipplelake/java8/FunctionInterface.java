package com.gipplelake.java8;

/**
 * @author dengqg
 * 函数式接口指的是只有一个抽象函数的接口，比如Runnable，Comparator等都是函数式接口
 * @FunctionalInterface。可以把他它放在一个接口前，表示这个接口是一个函数式接口。
 * 这个注解是非必须的，只要接口只包含一个抽象方法，虚拟机会认定该接口是函数式接口，不过最好在接口上使用注解 @FunctionalInterface 进行声明。
 * 在接口中添加了 @FunctionalInterface 的接口，只允许有一个抽象方法，否则编译器也会报错，默认方法可以有多个。
 * 函数式接口中的抽象方法，可以直接通过lamda表达式简化实现
 */
@FunctionalInterface
public interface FunctionInterface {
//    void test2();
    default  void test3(){

    }
    void test();
}

class Test {

    public static void run (FunctionInterface functionInterface){
        functionInterface.test();
    }
    public static void main(String[] args) {
        run(()-> System.out.println("123"));
    }
}