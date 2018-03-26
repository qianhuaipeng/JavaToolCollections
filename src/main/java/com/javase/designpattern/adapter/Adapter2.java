package com.javase.designpattern.adapter;

/**
 * author: alan.peng
 * description:
 * date: create in 13:45 2018/3/2
 * modified By：
 */
public class Adapter2 implements Ps2{

    Usb usb;

    public Adapter2(Usb usb){
        this.usb = usb;
    }

    @Override
    public void isPs2() {
        usb.isUsb();
    }

    public static void main(String[] args) {
        Ps2 ps = new Adapter2(new Usber());
        ps.isPs2();
    }
}
