package com.gipplelake.thinking_in_java.多路分发;

import java.util.Random;

/**
 * java一般只支持单路分发，也就是说如果要执行的操作包含了不止一个类型未知的对象时，java的动态绑定机制只能处理其中一个的类型
 * 可以使用多态实现多路分发。多态只能作用在方法调用上，所以需要俩路分发时，必须有俩个方法调用，第一个方法调用决定第一个未知类型，
 * 第二个方法调用决定第二个未知类型。
 *
 * @author dengqg
 */
interface Item {
    Outcome complete(Item it);

    Outcome eval(Pager p);

    Outcome eval(Scissors s);

    Outcome eval(Rock r);
}

class Pager implements Item {

    public Outcome complete(Item it) {
        return it.eval(this);
    }

    public Outcome eval(Pager p) {
        return Outcome.DRAW;
    }

    public Outcome eval(Scissors s) {
        return Outcome.LOSE;
    }

    public Outcome eval(Rock r) {
        return Outcome.WIN;
    }

    @Override
    public String toString() {
        return "Pager";
    }
}

class Scissors implements Item {

    public Outcome complete(Item it) {
        return it.eval(this);
    }

    public Outcome eval(Pager p) {
        return Outcome.WIN;
    }

    public Outcome eval(Scissors s) {
        return Outcome.DRAW;
    }

    public Outcome eval(Rock r) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {

    public Outcome complete(Item it) {
        return it.eval(this);
    }

    public Outcome eval(Pager p) {
        return Outcome.LOSE;
    }

    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }

    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Pager();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(a + " vs " + b + ":" + a.complete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
