package com.gipplelake.thinking_in_java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Covariant即协变，数组具有协变性，容器通过通配符实现协变，也可以实现逆变
 *
 * @author dengqg
 */
public class CovariantArrays {
    public static void main(String[] args) {
        //Apple的数组也是Fruit的数组，然而运行时fruits的类型是Apple[]
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();

        fruits[1] = new Jonathan();
        try {
            fruits[2] = new Banana();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[3] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }


        //Apple的list不是Fruit的list，所以引用通配符解决这个问题
        // List<Fruit> fruitList = new ArrayList<Apple>();
        List<? extends Fruit> fruitList = new ArrayList<Apple>(Arrays.asList(new Apple()));
        //现在list元素类型是? extends Fruit，没有指定特定类型，所以任何添加操作编译器都会出错
        //  fruitList.add(new Apple());
        //   fruitList.add(new Fruit());

        //contains ,indexOf方法可以正常使用，因为他们接收的参数类型是Object
        fruitList.contains(new Apple());


        //超类型通配符（逆变）； Apple是类型的下界，向其中添加Apple或者Apple的子类都是安全的，不能添加非Apple的对象
        List<? super Apple> apples = new ArrayList<Object>(Arrays.asList(new Object()));
        apples.add(new Apple());
        apples.add(new Jonathan());
       // apples.add(new Fruit());


    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Banana extends Fruit {
}
