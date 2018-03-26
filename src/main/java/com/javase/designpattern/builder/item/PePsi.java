package com.javase.designpattern.builder.item;

import com.javase.designpattern.builder.item.impl.ColdDrink;

/**
 * author: alan.peng
 * description:
 * date: create in 15:18 2018/3/25
 * modified By：
 */
public class PePsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 24.0f;
    }
}
