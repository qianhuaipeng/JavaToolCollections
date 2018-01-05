package com.javase.designpattern.proxy.test2.impl;

import com.javase.designpattern.proxy.test2.BookFacade;

/**
 * @author: alan.peng
 * @description:
 * @date: create in 14:57 2018/1/5
 * @modified By：
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }
}
