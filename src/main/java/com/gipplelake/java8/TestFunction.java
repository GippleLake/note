package com.gipplelake.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *  * Function<T, R>：将 T 作为输入，返回 R 作为输出
 * @author dengqg
 */
public class TestFunction {
    private static final List<Person> PERSONS = new ArrayList<Person>() {{
        add(new Person("Bim Tom", 2));
        add(new Person("Flaya Black", 10));
        add(new Person("Whaty Lake", 20));
    }};

    public static void main(String[] args) {
        //返回人的名字
        Function<Person, String> function = Person::getName;
        System.out.println(getNames(function));
        //返回空格之前的字符串
        Function<String, String> firstNameFunc = (String s) -> s.substring(0, s.indexOf(" "));

        //function组合，andThen 和compose调用顺序相反
        System.out.println(getNames(function.andThen(firstNameFunc)));
        System.out.println(getNames(firstNameFunc.compose(function)));

        //输入什么就输出什么
        System.out.println(getPersons(Function.identity()));
        System.out.println(getPersons((Person p) -> {
            p.setAge(100);
            return p;
        }));

    }

    static List<String> getNames(Function<Person, String> function) {
        List<String> result = new ArrayList<>();
        PERSONS.forEach(p -> result.add(function.apply(p)));
        return result;
    }

    static List<Person> getPersons(Function<Person, Person> function) {
        List<Person> result = new ArrayList<>();
        PERSONS.forEach(p -> result.add(function.apply(p)));
        return result;
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
