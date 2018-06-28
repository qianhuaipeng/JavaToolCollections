package com.javase.thread.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 14:08 2018/6/27
 * modified By：
 */
public class ProductConsumer {

    public static int i = 0;

    public static void main(String[] args) {
        ProductStack productStack = new ProductStack();

        Product product = new Product(productStack);
        new Thread(product).start();
        Product product1 = new Product(productStack);
        new Thread(product1).start();
        Consumer consumer = new Consumer(productStack);
        new Thread(consumer).start();


    }
}
