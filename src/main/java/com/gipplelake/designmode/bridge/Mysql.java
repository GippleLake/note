package com.gipplelake.designmode.bridge;


/**
 * @author dengqg
 */
public class Mysql {
    public void connect(Bridge bridge) {
        System.out.println(bridge.getName() + " connected mysql");
    }
}

class Test {
    public static void main(String[] args) {
        Mysql mysql = new Mysql();
        Bridge bridge = new Bridge();
        bridge.setDriver(new OneDriver());
        mysql.connect(bridge);
        bridge.setDriver(new TowDriver());
        mysql.connect(bridge);
    }
}
