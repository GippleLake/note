package com.gipplelake.designmode.factory.factory1;

import com.gipplelake.designmode.factory.EmailSender;
import com.gipplelake.designmode.factory.SmsSender;

/**
 * @author dengqg
 */
public class MessageFactory {

    EmailSender createEmailSender() {
        return new EmailSender();
    }

    SmsSender createSmsSender() {
        return new SmsSender();
    }
}
