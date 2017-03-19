package com.gipplelake.thinking_in_java.generics.generator;

/**
 * @author dengqg
 */
class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    //泛型化的create方法用于减少类创建代码
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }

    public static void main(String[] args) {
        //简化前
        CountObject basicGenerator = new BasicGenerator<CountObject>(CountObject.class).next();
        //简化后
        CountObject simpleBasicGenerator = BasicGenerator.create(CountObject.class).next();


    }
}

class CountObject {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "CountObject{" +
                "id=" + id +
                '}';
    }
}

