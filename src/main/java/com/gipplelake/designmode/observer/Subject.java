package com.gipplelake.designmode.observer;

/**
 * @author dengqg
 */
public interface Subject {
    void modify();

    void addObserver(Observer observer);
}
