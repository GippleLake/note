package com.gipplelake.thinking_in_java.generics.create_instance.sample1;

/**
 * 创建泛型类的实例
 * 运行时才能捕获到错误，不推荐，推荐（sample2和3）
 * @author dengqg
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<Employee>(Employee.class);
        //没有默认的构造函数，将会失败
        ClassAsFactory<Integer> factory1 = new ClassAsFactory<Integer>(Integer.class);
    }
}

class Employee {
}
