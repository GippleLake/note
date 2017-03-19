package com.gipplelake.designmode.decorator;

/**
 * @author dengqg
 */
public class SourceDecorator implements Source {
    Sourceable sourceable;

    public SourceDecorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    public void hello() {
        sourceable.hello();
        System.out.println("after decorator ---- ");
    }
}

class Test {
    public static void main(String[] args) {
        Source source = new SourceDecorator(new Sourceable());
        source.hello();
    }
}
