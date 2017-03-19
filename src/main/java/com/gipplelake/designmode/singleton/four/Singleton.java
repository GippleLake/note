package com.gipplelake.designmode.singleton.four;

/**
 * "This approach is functionally equivalent to the public field approach,
 * except that it is more concise, provides the serialization machinery for free,
 * and provides an ironclad guarantee against multiple instantiation,
 * even in the face of sophisticated serialization or reflection attacks.
 * While this approach has yet to be widely adopted, a single-element enum type is the best way to implement a singleton."
 *
 * @author dengqg
 */
public enum Singleton {
    instance;
    private String s = "hahaha ";

    public static Singleton getInstance() {
        return instance;
    }

    public void say() {
        System.out.println(s);
    }

}

class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.say();
    }
}
