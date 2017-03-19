package com.gipplelake.designmode.proxy;

/**
 * @author dengqg
 */
public class RealObject implements DoWhat {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);

    }
}
