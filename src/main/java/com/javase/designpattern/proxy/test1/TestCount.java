package com.javase.designpattern.proxy.test1;

import com.javase.designpattern.proxy.test1.impl.CountImpl;

/**
 * @author: alan.peng
 * @description:
 * @date: create in 14:43 2018/1/5
 * @modified By：
 */
public class TestCount {

    public static void main(String[] args) {
        CountImpl count = new CountImpl();
        CountProxy countProxy = new CountProxy(count);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}
