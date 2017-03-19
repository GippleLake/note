package com.gipplelake.designmode.facade;

/**
 * @author dengqg
 */
public class Computer {
    CPU cpu;
    Disk disk;
    Screen screen;

    Computer() {
        cpu = new CPU();
        disk = new Disk();
        screen = new Screen();
    }

    public void start() {
        cpu.start();
        disk.start();
        screen.start();
    }

    public void stop() {
        cpu.stop();
        disk.stop();
        screen.stop();
    }
}
