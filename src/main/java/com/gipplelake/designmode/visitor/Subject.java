package com.gipplelake.designmode.visitor;

/**
 * @author dengqg
 */
public interface Subject {
    void accept(Visitor visitor);

    String getSubject();
}
