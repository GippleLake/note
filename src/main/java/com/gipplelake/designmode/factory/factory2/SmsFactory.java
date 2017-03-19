package com.gipplelake.designmode.factory.factory2;

import com.gipplelake.designmode.factory.Sender;
import com.gipplelake.designmode.factory.SmsSender;

/**
 * @author dengqg
 */
public class SmsFactory implements Factory {
    public Sender createSender() {
        return new SmsSender();
    }
}
