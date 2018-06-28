package com.javase.designpattern.chainofresponsibility;

/**
 * author: alan.peng
 * description:
 * date: create in 16:58 2018/3/27
 * modified By：
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
