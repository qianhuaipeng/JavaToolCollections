package com.javase.thread.queue.block.test1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * author: alan.peng
 * description:
 * date: create in 10:57 2018/4/28
 * modified By：
 */
public class Basket {

    BlockingQueue<String> basket = new LinkedBlockingDeque<String>(4);
    private int count = 1;
    public void produce() throws InterruptedException {
        //put方法放一个苹果，若basket满了，等到basket有位置
        basket.put("An apple" + count++);
    }

    public String consume () throws InterruptedException{
        //take 方法取出一个苹果，若basket为空，等到basket有苹果为止（获取并移除此队列的头部）
        return basket.take();
    }


    public int size(){
        return basket.size();
    }

}
