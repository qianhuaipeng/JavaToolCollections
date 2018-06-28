package com.javase.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:48 2018/3/28
 * modified By：
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
