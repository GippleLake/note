package com.gipplelake.designmode.visitor;

/**
 * @author dengqg
 */
public class MySubject implements Subject {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getSubject() {
        return "lalla my subject";
    }
}
