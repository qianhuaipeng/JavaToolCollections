package com.javase.thread.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 9:50 2018/6/27
 * modified By：
 */
public class TwoThreadWaitNotify {

    public int start = 1;
    public boolean flag = false;


    public static void main(String[] args) {
        TwoThreadWaitNotify twoThreadWaitNotify = new TwoThreadWaitNotify();
        OddThread oddThread = new OddThread(twoThreadWaitNotify);
        EvenThread evenThread = new EvenThread(twoThreadWaitNotify);
        Thread t1 = new Thread(oddThread);
        t1.start();
        Thread t2 = new Thread(evenThread);
        t2.start();
    }
}
