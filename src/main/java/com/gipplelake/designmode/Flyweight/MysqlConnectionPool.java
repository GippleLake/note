package com.gipplelake.designmode.Flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengqg
 */
public class MysqlConnectionPool {
    List<MysqlConnection> connections;

    MysqlConnectionPool() {
        connections = new ArrayList<MysqlConnection>(100);
        for (int i = 0; i < 100; i++) {
            connections.add(new MysqlConnection());
        }

    }

    public MysqlConnection getConnection() {
        if (connections.size() > 0) {
            MysqlConnection connection = connections.get(0);
            connections.remove(connection);
            return connection;
        }
        return new MysqlConnection();
    }

}


class Test {
    public static void main(String[] args) {
        MysqlConnectionPool pool = new MysqlConnectionPool();
        MysqlConnection connection = pool.getConnection();
    }
}
