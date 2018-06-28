package com.javase.thread.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 9:35 2018/6/27
 * modified By：
 */
public class OddThread implements Runnable {

    boolean flag = true;
    private TwoThreadWaitNotify number;

    public OddThread(TwoThreadWaitNotify twoThreadWaitNotify){
        this.number = twoThreadWaitNotify;
    }

    @Override
    public void run() {
        while (number.start < 100) {
            synchronized (TwoThreadWaitNotify.class) {
                System.out.println("奇数线程抢到锁了。。。");
                if (number.flag) {
                    System.out.println(number.start);
                    number.start ++;
                    number.flag = false;
                    TwoThreadWaitNotify.class.notify();
                } else {
                    try {
                        TwoThreadWaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        }


    }
}
