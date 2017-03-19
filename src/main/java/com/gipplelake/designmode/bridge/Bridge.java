package com.gipplelake.designmode.bridge;

/**
 * @author dengqg
 */
public class Bridge {
    Driver driver;

    Bridge() {
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getName() {
        return driver.getName();
    }
}
