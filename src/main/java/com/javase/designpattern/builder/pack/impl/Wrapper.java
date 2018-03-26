package com.javase.designpattern.builder.pack.impl;

import com.javase.designpattern.builder.pack.Packing;

/**
 * author: alan.peng
 * description: 袋子打包工具
 * date: create in 14:49 2018/3/25
 * modified By：
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "wrapper";
    }
}
