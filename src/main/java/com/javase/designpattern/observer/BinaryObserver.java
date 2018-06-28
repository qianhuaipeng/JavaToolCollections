package com.javase.designpattern.observer;

/**
 * author: alan.peng
 * description:
 * date: create in 10:55 2018/3/28
 * modified By：
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
