package com.javase.thread.queue.block.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: alan.peng
 * description:
 * date: create in 10:55 2018/4/28
 * modified By：
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        Basket basket = new Basket();
        ExecutorService service = Executors.newCachedThreadPool();

        Producer producer1 = new Producer("生产者001",basket);
        Producer producer2 = new Producer("生产者002",basket);
        Consumer consumer1 = new Consumer("消费者001", basket);

        service.submit(producer1);
        service.submit(producer2);
        service.submit(consumer1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdownNow();
    }
}
