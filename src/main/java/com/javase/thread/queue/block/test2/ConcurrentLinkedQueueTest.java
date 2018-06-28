package com.javase.thread.queue.block.test2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: alan.peng
 * description:
 * date: create in 11:33 2018/4/28
 * modified By：
 */
public class ConcurrentLinkedQueueTest {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    private static int count = 2;

    private static CountDownLatch latch = new CountDownLatch(count);

    public static void offer(){
        for (int i=0;i< 10000; i++) {
            queue.offer(i);
        }
    }

    static class Poll implements Runnable {
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }

            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(4);
        ConcurrentLinkedQueueTest.offer();
        for (int i = 0; i < count; i++) {
            es.submit(new Poll());
        }
        latch.await(); //使得主线程(main)阻塞直到latch.countDown()为零才继续执行
        System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
        es.shutdown();
    }
}
