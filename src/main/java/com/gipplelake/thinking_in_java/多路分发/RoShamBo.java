package com.gipplelake.thinking_in_java.多路分发;

import java.util.Random;

/**
 * @author dengqg
 */
public class RoShamBo {
    private static Random random = new Random();
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs " + b + ":" + a.compete(b));
    }

    public static <T  extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(randomEnum(rsbClass),randomEnum(rsbClass));
        }
    }
    public static <T extends Enum<T>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
