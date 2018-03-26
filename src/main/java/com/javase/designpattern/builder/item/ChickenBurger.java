package com.javase.designpattern.builder.item;

import com.javase.designpattern.builder.item.impl.Burger;

/**
 * author: alan.peng
 * description: 鸡腿汉堡实现类
 * date: create in 15:14 2018/3/25
 * modified By：
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chincken Burger";
    }

    @Override
    public float price() {
        return 34.0f;
    }
}
