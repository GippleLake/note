package com.gipplelake.designmode.command;

/**
 * @author dengqg
 */
public class Invoke {
    Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void exe() {
        command.cleanFloor();
    }
}
