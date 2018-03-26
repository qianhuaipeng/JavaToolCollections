package com.javase.designpattern.builder.item.impl;

import com.javase.designpattern.builder.item.Item;
import com.javase.designpattern.builder.pack.Packing;
import com.javase.designpattern.builder.pack.impl.Bottle;

/**
 * author: alan.peng
 * description: 冷饮打包工具抽象类
 * date: create in 14:54 2018/3/25
 * modified By：
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price() ;
}
