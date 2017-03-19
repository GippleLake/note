package com.gipplelake.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengqg
 */
public class SubjectImpl implements Subject {

    List<Observer> observers = new ArrayList<Observer>();

    public void modify() {
        System.out.println("update lalala ");
        notifyObserver();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObserver() {
        for (Observer observer : observers) {
            observer.receive();
        }
    }
}

class Test {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        subject.addObserver(new ObserverImpl());
        subject.modify();
    }
}
