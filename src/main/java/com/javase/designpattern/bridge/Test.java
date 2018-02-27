package com.javase.designpattern.bridge;

import com.javase.designpattern.bridge.impl.AreaB3;

/**
 * author: alan.peng
 * description:
 * date: create in 9:52 2018/2/27
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        AreaA a = new AreaA2();
        a.qiao = new AreaB3();
        a.fromAreaA();
        a.qiao.targetAreaB();
    }
}
