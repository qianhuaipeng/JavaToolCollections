package com.javase.designpattern.builder.item;

import com.javase.designpattern.builder.item.impl.Burger;

/**
 * author: alan.peng
 * description: 创建扩展了Burger,蔬菜汉堡实现类
 * date: create in 15:12 2018/3/25
 * modified By：
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Vge Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
