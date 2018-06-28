package com.javase.designpattern.decorator.impl;

import com.javase.designpattern.decorator.Shape;

/**
 * author: alan.peng
 * description:
 * date: create in 15:05 2018/3/27
 * modified By：
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: circle");
    }
}
