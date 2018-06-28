package com.javase.thread.test4;


/**
 * author: alan.peng
 * description:
 * date: create in 15:41 2018/6/27
 * modified By：
 */
public class Product implements Runnable{

    //每次生产产品的数量
    private int num;

    private Storage storage;

    public Product(int num, Storage storage) {
        this.num = num;
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.produce(num);
    }
}
