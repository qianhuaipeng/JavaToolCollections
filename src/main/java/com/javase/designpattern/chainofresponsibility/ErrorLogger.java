package com.javase.designpattern.chainofresponsibility;

/**
 * author: alan.peng
 * description:
 * date: create in 17:00 2018/3/27
 * modified By：
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
