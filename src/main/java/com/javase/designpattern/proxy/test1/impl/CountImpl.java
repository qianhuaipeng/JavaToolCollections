package com.javase.designpattern.proxy.test1.impl;

import com.javase.designpattern.proxy.test1.Count;

/**
 * @author: alan.peng
 * @description:
 * @date: create in 14:34 2018/1/5
 * @modified By：
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("查看账户方法。。。");
    }

    @Override
    public void updateCount() {
        System.out.println("修改账户方法。。。");
    }


}
