package com.javase.designpattern.builder.item;

import com.javase.designpattern.builder.item.impl.ColdDrink;

/**
 * author: alan.peng
 * description:
 * date: create in 15:16 2018/3/25
 * modified By：
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
