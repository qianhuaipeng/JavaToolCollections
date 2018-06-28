package com.javase.thread.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 14:06 2018/6/27
 * modified By：
 */
public class ProductStack {

    boolean isPro = true;

    public synchronized void push(){
        if (!isPro) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        ProductConsumer.i++;
        System.out.println("第：" + ProductConsumer.i + "个产品，生产者：" + Thread.currentThread().getName());
        isPro = false;
        try {
            Thread.sleep((int)Math.random() * 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void pop(){
        if (isPro) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        System.out.println("消费者：" + Thread.currentThread().getName() + "\t"+ ProductConsumer.i-- );
        isPro = true;
        try {
            Thread.sleep((int)Math.random() * 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
