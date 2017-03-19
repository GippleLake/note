package com.gipplelake.designmode.observer;

/**
 * @author dengqg
 */
public class ObserverImpl implements Observer {
    public void receive() {
        System.out.println("observer receive update");
    }
}
