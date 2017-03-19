package com.gipplelake.designmode.strategy;

/**
 * @author dengqg
 */
public class Plus extends Calculate {
    @Override
    Integer calculate(int a, int b) {
        return a + b;
    }
}
