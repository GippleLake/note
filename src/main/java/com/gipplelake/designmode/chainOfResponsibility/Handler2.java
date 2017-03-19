package com.gipplelake.designmode.chainOfResponsibility;

/**
 * @author dengqg
 */
public class Handler2 extends AbstractHandler {
    Handler3 handler3 = new Handler3();

    @Override

    public Handler getHandler() {
        return handler3;
    }

    public void invoke() {
        System.out.println("handler2 executed ");
        invokeNext();
    }
}
