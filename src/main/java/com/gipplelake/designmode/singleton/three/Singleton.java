package com.gipplelake.designmode.singleton.three;

/**
 * 几乎完美。其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错
 *
 * @author dengqg
 */
public class Singleton {


    private Singleton() {

    }

    private static class SingletonFactory {
        public static Singleton instance = new Singleton();

    }

    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }
}

