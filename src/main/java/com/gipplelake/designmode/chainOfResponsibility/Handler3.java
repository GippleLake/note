package com.gipplelake.designmode.chainOfResponsibility;

/**
 * @author dengqg
 */
public class Handler3 extends AbstractHandler {
    @Override
    public Handler getHandler() {
        return null;
    }

    public void invoke() {
        System.out.println("handler3 executed");
    }

    public static void main(String[] args) {
        Handler1 handler3 = new Handler1();
        handler3.invoke();
    }
}

