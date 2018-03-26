package com.javase.designpattern.adapter;

/**
 * author: alan.peng
 * description:
 * date: create in 11:58 2018/3/2
 * modified By：
 */
public class Usber implements Usb {
    @Override
    public void isUsb() {
        System.out.println("使用usb接口");
    }
}
