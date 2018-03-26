package com.javase.designpattern.builder.item;

import com.javase.designpattern.builder.pack.Packing;

/**
 * author: alan.peng
 * description:
 * date: create in 14:45 2018/3/25
 * modified By：
 */
public interface Item {

    String name();

    Packing packing();

    float price();
}
