package com.javase.thread.test3;

/**
 * author: alan.peng
 * description:
 * date: create in 15:44 2018/6/27
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Product p1 = new Product(10, storage);
        new Thread(p1).start();
        Product p2 = new Product(20, storage);
        new Thread(p2).start();
        Consumer c1 = new Consumer(10,storage);
        new Thread(c1).start();
        Consumer c2 = new Consumer(30,storage);
        new Thread(c2).start();
    }

}
