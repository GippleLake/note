package com.gipplelake.designmode.builder.one;

/**
 * @author dengqg
 */
public interface Builder {
    void createBody();

    void createFoot();

    void createHand();

    void createHead();

    Person getPerson();
}
