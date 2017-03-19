package com.gipplelake.designmode.builder.one;

/**
 * @author dengqg
 */
public class Test {
    public static void main(String[] args) {
        BuilderImpl builder = new BuilderImpl();
        Concrete concrete = new Concrete(builder);
        concrete.concrete();
        builder.getPerson();
    }
}
