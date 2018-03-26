package com.javase.designpattern.builder.pack.impl;

import com.javase.designpattern.builder.pack.Packing;

/**
 * author: alan.peng
 * description: 瓶装打包工具
 * date: create in 14:50 2018/3/25
 * modified By：
 */
public class Bottle implements Packing{

    @Override
    public String pack() {
        return "bottle";
    }
}
