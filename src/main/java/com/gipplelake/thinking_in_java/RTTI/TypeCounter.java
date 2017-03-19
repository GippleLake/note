package com.gipplelake.thinking_in_java.RTTI;

import java.util.HashMap;

/**
 * @author dengqg
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> type;
    private int count = 0;

    public TypeCounter(Class<?> type) {
        this.type = type;
    }

    public void count(Object o) {
        Class<?> oType = o.getClass();
        if (!type.isAssignableFrom(oType)) {
            return;
        }
        countClass(oType);

    }

    private void countClass(Class<?> oType) {
        Integer quantity = get(oType);
        put(oType, quantity == null ? 1 : quantity + 1);
        Class<?> oSuperType = oType.getSuperclass();
        if (oSuperType != null && type.isAssignableFrom(oSuperType)) {
            countClass(oSuperType);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Class<?> key : keySet()) {
            stringBuilder.append(key.toString()).append(get(key));
        }
        return stringBuilder.toString();
    }
}

class TestTypeCounter {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Number.class);
        typeCounter.count(1);
        typeCounter.count(1);
        typeCounter.count(1);
        TypeCounter typeCounter2 = new TypeCounter(String.class);
        typeCounter2.count("23");
        typeCounter2.count("23");
        System.out.println(typeCounter);
        System.out.println(typeCounter2);

    }
}

