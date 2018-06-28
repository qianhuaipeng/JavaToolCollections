package com.javase.thread.test4;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: alan.peng
 * description:
 * date: create in 14:56 2018/6/27
 * modified By：
 */
public class Storage {

    //仓库最大存储量
    private final int MAX_SIZE = 100;

    //仓库存储的载体
    private LinkedList<Object> list = new LinkedList<>();

    private final Lock lock = new ReentrantLock();

    //仓库满的条件变量
    private final Condition full = lock.newCondition();

    //仓库空的条件变量
    private final Condition empty = lock.newCondition();


    /**
     * 生产num个产品
     * @param num
     */
    public void produce(int num){
        //获得锁
        lock.lock();
        //如果仓库剩余容量不足
        while (list.size() + num > MAX_SIZE) {
            System.out.println("【要生产的产品数量】：" + num + "\t【库存量】：" + list.size() + "\t暂时不能执行生产任务。");
            try {
                //由于条件不满足，生产阻塞
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= num; ++i) {
            list.add(new Object());
        }
        System.out.println("已经生产产品数：" + num + "\t【现仓库存储量为】：" + list.size());
        //唤醒所有其他的线程
        full.signalAll();
        empty.signalAll();

        //释放锁
        lock.unlock();
    }


    public void consume(int num) {
        lock.lock();

        //如果仓库存储量不足
        while (num > list.size()) {
            System.out.println("【要消费的产品数量】：" + num + "\t【库存量】：" + list.size() + "\t暂不能执行生产任务！");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i=1; i <= num; ++i) {
            list.remove();
        }
        System.out.println("【已经消费的产品数量】：" + num + "\t【现仓库存储量】：" + list.size());

        full.signalAll();
        empty.signalAll();

        lock.unlock();
    }
}
