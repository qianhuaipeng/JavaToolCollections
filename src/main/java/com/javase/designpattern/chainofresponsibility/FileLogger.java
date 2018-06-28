package com.javase.designpattern.chainofresponsibility;

/**
 * author: alan.peng
 * description:
 * date: create in 17:01 2018/3/27
 * modified By：
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger:" + message);
    }
}
