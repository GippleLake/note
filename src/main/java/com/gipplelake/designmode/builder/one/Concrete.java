package com.gipplelake.designmode.builder.one;

/**
 * @author dengqg
 */
public class Concrete {
    private Builder builder;

    public Concrete(Builder builder) {
        this.builder = builder;
    }

    public void concrete() {
        builder.createBody();
        builder.createFoot();
        builder.createHand();
        builder.createHead();
    }
}
