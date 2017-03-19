package com.gipplelake.designmode.command;

/**
 * @author dengqg
 */
public class Command {

    Receive receive;

    public Command(Receive receive) {
        this.receive = receive;
    }

    public void cleanFloor() {
        System.out.println("clean floor");
        receive.action();
    }
}

class Test {
    public static void main(String[] args) {
        Receive receive = new Receive();
        Command command = new Command(receive);
        Invoke invoke = new Invoke(command);
        invoke.exe();
    }
}
