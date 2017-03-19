package com.gipplelake.designmode.strategy;

/**
 * @author dengqg
 */
public class Minus extends Calculate {
    @Override
    Integer calculate(int a, int b) {
        return a - b;
    }
}
