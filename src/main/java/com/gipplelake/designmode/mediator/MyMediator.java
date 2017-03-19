package com.gipplelake.designmode.mediator;

/**
 * @author dengqg
 */
public class MyMediator implements Mediator {

    private User1 user1;
    private User2 user2;

    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    public void workAll() {
        user1.work();
        user2.work();
    }
}

class Test {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
