package com.javase.designpattern.observer;

/**
 * author: alan.peng
 * description:
 * date: create in 10:56 2018/3/28
 * modified By：
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
