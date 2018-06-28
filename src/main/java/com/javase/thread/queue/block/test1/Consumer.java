package com.javase.thread.queue.block.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 11:06 2018/4/28
 * modified By：
 */
public class Consumer implements Runnable {

    private String instance;
    private Basket basket;

    public Consumer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("消费者准备消费苹果：" + instance);
                //basket.consume();
                System.out.println("消费者消费苹果：" + basket.consume());
                System.out.println("篮子里面苹果数量：" + basket.size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
