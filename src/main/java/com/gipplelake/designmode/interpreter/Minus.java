package com.gipplelake.designmode.interpreter;

/**
 * @author dengqg
 */
public class Minus implements Expression {
    public int interpreter(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
