package com.gipplelake.designmode.adapter.one;

/**
 * @author dengqg
 */
public class TargetImpl extends Source implements Target {
    @Override
    public void say() {
        super.say();
        System.out.println("rewrite say -----");
    }

    public void run() {
        System.out.println("run-----");
    }
}

class Test {
    public static void main(String[] args) {
        TargetImpl i = new TargetImpl();
        i.say();
    }
}