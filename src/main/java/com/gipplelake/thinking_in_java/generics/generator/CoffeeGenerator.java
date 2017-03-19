package com.gipplelake.thinking_in_java.generics.generator;

import java.util.*;

//想通过foreach遍历元素，需要实现Iterable（可遍历的），并提供Iterator（遍历器）
class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] coffeeType = {Mocha.class, Latte.class, Breve.class};

    private Random random = new Random();

    //iterator中使用
    private int size;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {
    }

    public Coffee next() {
        try {
            return (Coffee) coffeeType[random.nextInt(coffeeType.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        private int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            //重要
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }

        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }


}


