package com.javase.designpattern.decorator.impl;

import com.javase.designpattern.decorator.Shape;

/**
 * author: alan.peng
 * description: 正方形
 * date: create in 15:04 2018/3/27
 * modified By：
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: rectangle.");
    }
}
