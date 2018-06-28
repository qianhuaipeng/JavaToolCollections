package com.javase.designpattern.adapter.usb;

/**
 * author: alan.peng
 * description:
 * date: create in 13:45 2018/3/2
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        Ps2 p = new Adapter();
        p.isPs2();
    }
}
