package com.gipplelake.designmode.interpreter;

/**
 * @author dengqg
 */
public class Plus implements Expression {
    public int interpreter(Context context) {
        return context.getNum1() + context.getNum2();
    }
}

class Test {
    public static void main(String[] args) {
        int result = new Minus().interpreter((new Context(new Plus()
                .interpreter(new Context(9, 2)), 8)));
        System.out.println(result);
    }
}