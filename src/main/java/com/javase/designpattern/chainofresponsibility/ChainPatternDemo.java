package com.javase.designpattern.chainofresponsibility;

/**
 * author: alan.peng
 * description:
 * date: create in 17:04 2018/3/27
 * modified By：
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,"This is a information");

        loggerChain.logMessage(AbstractLogger.DEBUG,"This is a debug information");

        loggerChain.logMessage(AbstractLogger.ERROR,"This is a error information");
    }
}
