package com.gipplelake.designmode.factory.factory1;

import com.gipplelake.designmode.factory.EmailSender;
import com.gipplelake.designmode.factory.SmsSender;

/**
 * @author dengqg
 */
public class Test {
    public static void main(String[] args) {
        MessageFactory factory = new MessageFactory();
        EmailSender emailSender = factory.createEmailSender();
        SmsSender smsSender = factory.createSmsSender();
        emailSender.send();
        smsSender.send();
    }
}
