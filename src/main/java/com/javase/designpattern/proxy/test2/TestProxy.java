package com.javase.designpattern.proxy.test2;

import com.javase.designpattern.proxy.test2.impl.BookFacadeImpl;

/**
 * author: alan.peng
 * description:
 * date: create in 15:04 2018/1/5
 * modified By：
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookFacade.addBook();
    }
}
