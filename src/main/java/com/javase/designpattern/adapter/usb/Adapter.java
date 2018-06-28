package com.javase.designpattern.adapter.usb;

/**
 * author: alan.peng
 * description:
 * date: create in 13:44 2018/3/2
 * modified By：
 */
public class Adapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }
}
