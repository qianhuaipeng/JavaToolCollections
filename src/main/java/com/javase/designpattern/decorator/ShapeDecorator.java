package com.javase.designpattern.decorator;

/**
 * author: alan.peng
 * description:
 * date: create in 15:09 2018/3/27
 * modified By：
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }



}
