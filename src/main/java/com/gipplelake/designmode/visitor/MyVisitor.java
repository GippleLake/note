package com.gipplelake.designmode.visitor;


/**
 * @author dengqg
 */
public class MyVisitor implements Visitor {
    public void visit(Subject subject) {
        System.out.println("visitor the subject:" + subject.getSubject());
    }
}

class Test {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        visitor.visit(new MySubject());
    }
}
