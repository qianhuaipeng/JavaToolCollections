package com.javase.designpattern.observer;

/**
 * author: alan.peng
 * description:
 * date: create in 10:52 2018/3/28
 * modified By：
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String : " + Integer.toOctalString(subject.getState()));
    }
}
