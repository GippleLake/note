package com.gipplelake.designmode.factory.factory2;

import com.gipplelake.designmode.factory.EmailSender;
import com.gipplelake.designmode.factory.Sender;

/**
 * @author dengqg
 */
public class EmailFactory implements Factory {
    public Sender createSender() {
        return new EmailSender();
    }
}
