package com.gipplelake.designmode.chainOfResponsibility;

/**
 * @author dengqg
 */
public abstract class AbstractHandler implements Handler {

    public abstract Handler getHandler();

    public void invokeNext() {
        if (getHandler() != null) {
            getHandler().invoke();
        }
    }
}
