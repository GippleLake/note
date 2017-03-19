package com.gipplelake.designmode;

/**
 * @author dengqg
 */
public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        //Thread.sleep(1000);
        new Thread(c).start();
    }
}

class ManTou {//馒头
    int id;

    ManTou(int id) {
        this.id = id;
    }

    public String toString() {
        return "馒头:" + id;
    }
}

class SyncStack {//篮子
    transient int index = 0;
    ManTou[] arrMT = new ManTou[20];

    public synchronized void push(ManTou mt) {
        while (index == arrMT.length - 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        arrMT[index] = mt;
        index++;
    }

    public synchronized ManTou pop() {
        while (index == arrMT.length - 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrMT[index];
    }
}

class Producer implements Runnable {
    SyncStack ss = null;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou mt = new ManTou(i);
            ss.push(mt);
            System.out.println("生产了" + mt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    SyncStack ss = null;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou mt = ss.pop();
            System.out.println("消费了" + mt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
