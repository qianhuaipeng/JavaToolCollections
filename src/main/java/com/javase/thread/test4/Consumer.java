package com.javase.thread.test4;


/**
 * author: alan.peng
 * description:
 * date: create in 15:41 2018/6/27
 * modified By：
 */
public class Consumer implements Runnable {

    private int num;
    private Storage storage;

    public Consumer(int num, Storage storage) {
        this.num = num;
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.consume(num);
    }
}
