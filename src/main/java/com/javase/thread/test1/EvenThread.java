package com.javase.thread.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 9:36 2018/6/27
 * modified By：
 */
public class EvenThread implements Runnable {

    boolean flag = true;
    private TwoThreadWaitNotify number;

    public EvenThread(TwoThreadWaitNotify number){
        this.number = number;
    }

    @Override
    public void run() {
       while (number.start < 100) {
           synchronized (TwoThreadWaitNotify.class) {
               System.out.println("偶数线程抢到锁了。。。");
               if (number.flag) {
                   try {
                       TwoThreadWaitNotify.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               } else {
                   System.out.println(number.start);
                   number.start ++;
                   number.flag = true;
                   TwoThreadWaitNotify.class.notify();
               }
           }
       }
    }
}
