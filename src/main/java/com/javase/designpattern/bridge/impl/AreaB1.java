package com.javase.designpattern.bridge.impl;

import com.javase.designpattern.bridge.Qiao;

/**
 * author: alan.peng
 * description:
 * date: create in 9:45 2018/2/27
 * modified By：
 */
public class AreaB1 implements Qiao {

    @Override
    public void targetAreaB() {
        System.out.println("我要去B1");
    }
}