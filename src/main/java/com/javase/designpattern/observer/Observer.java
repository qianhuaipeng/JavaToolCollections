package com.javase.designpattern.observer;

/**
 * author: alan.peng
 * description:
 * date: create in 10:47 2018/3/28
 * modified By：
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
