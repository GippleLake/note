package com.gipplelake.designmode.factory;

/**
 * @author dengqg
 */
public class EmailSender implements Sender {
    public void send() {
        System.out.println("send email");
    }
}
