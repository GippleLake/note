package com.gipplelake.designmode.strategy;

/**
 * @author dengqg
 */
class Test {
    public static void main(String[] args) {
        Calculate plus = new Plus();
        Integer result = plus.calculate(10, 10);
        System.out.println(result);
    }
}