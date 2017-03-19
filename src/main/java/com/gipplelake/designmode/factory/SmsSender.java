package com.gipplelake.designmode.factory;

/**
 * @author dengqg
 */
public class SmsSender implements Sender {
    public void send() {
        System.out.println("send message");
    }
}
