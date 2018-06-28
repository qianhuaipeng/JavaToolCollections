package com.javase.thread.queue.block.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 11:01 2018/4/28
 * modified By：
 */
public class Producer implements Runnable {

    private String instance;
    private Basket basket;

    public Producer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }


    @Override
    public void run() {
        try{
            while (true) {
                System.out.println("生产者准备生产苹果：" + instance);
                basket.produce();
                //System.out.println("生产者生产苹果结束：" + instance);
                System.out.println("篮子里面苹果数量：" + basket.size());
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {

        }
    }
}
