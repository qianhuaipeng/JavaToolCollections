package com.javase.designpattern.decorator;

import com.javase.designpattern.decorator.impl.Circle;
import com.javase.designpattern.decorator.impl.Rectangle;
import sun.security.provider.SHA;

/**
 * author: alan.peng
 * description:
 * date: create in 15:24 2018/3/27
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println();
        System.out.println("Circle of red border.");
        redCircle.draw();

        System.out.println();
        System.out.println("Rectangle of red border");
        redRectangle.draw();

    }
}
