package com.javase.designpattern.observer;

/**
 * author: alan.peng
 * description:
 * date: create in 10:57 2018/3/28
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        subject.notifyAllObservers();
        System.out.println("Second state change: 10");
        subject.setState(10);
        subject.notifyAllObservers();
    }
}
