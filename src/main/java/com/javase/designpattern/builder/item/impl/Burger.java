package com.javase.designpattern.builder.item.impl;

import com.javase.designpattern.builder.item.Item;
import com.javase.designpattern.builder.pack.Packing;
import com.javase.designpattern.builder.pack.impl.Wrapper;

/**
 * author: alan.peng
 * description:创建实现 Item 接口的抽象类，该类提供了默认的功能。 汉堡包抽象类
 * date: create in 14:52 2018/3/25
 * modified By：
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
