package com.gipplelake.designmode.factory.factory2;

/**
 * @author dengqg
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new EmailFactory();
        factory.createSender().send();
    }
}
