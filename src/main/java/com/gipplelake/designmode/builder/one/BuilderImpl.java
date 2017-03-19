package com.gipplelake.designmode.builder.one;

/**
 * @author dengqg
 */
public class BuilderImpl implements Builder {

    Person person;

    public void createBody() {
        System.out.println("createBody");
    }

    public void createFoot() {
        System.out.println("createFoot");
    }

    public void createHand() {
        System.out.println("createHand");
    }

    public void createHead() {
        System.out.println("createHead");
    }

    public Person getPerson() {
        System.out.println("getPerson");
        return person;

    }
}
