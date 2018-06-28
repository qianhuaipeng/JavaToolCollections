package com.javase.thread.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 14:04 2018/6/27
 * modified By：
 */
public class Product implements Runnable {

    private ProductStack productStack;

    public Product(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        while (true) {
            if (ProductConsumer.i < 100) {
                productStack.push();
            } else {
                break;
            }
        }
    }
}
