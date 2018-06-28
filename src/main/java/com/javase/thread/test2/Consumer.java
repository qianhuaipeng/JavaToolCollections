package com.javase.thread.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 14:05 2018/6/27
 * modified By：
 */
public class Consumer implements Runnable {

    private ProductStack productStack;

    public Consumer(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true) {
            if (ProductConsumer.i < 100) {
                productStack.pop();
            } else {
                break;
            }
        }
    }
}
