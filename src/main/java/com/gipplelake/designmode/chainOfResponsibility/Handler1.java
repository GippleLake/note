package com.gipplelake.designmode.chainOfResponsibility;

/**
 * @author dengqg
 */
public class Handler1 extends AbstractHandler {

    Handler2 handler2 = new Handler2();

    public Handler getHandler() {
        return handler2;
    }

    public void invoke() {
        System.out.println("handler1 executed ");
        invokeNext();
    }
}
