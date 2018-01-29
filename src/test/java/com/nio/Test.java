package com.nio;

import java.lang.reflect.Field;

/**
 * author: alan.peng
 * description:
 * date: create in 16:06 2018/1/8
 * modified By：
 */
public class Test {

    public static void main(String[] args) throws Exception{
        Class<?> c = Class.forName("java.nio.Bits");
        Field maxMemory = c.getDeclaredField("maxMemory");
        maxMemory.setAccessible(true);
        Field reservedMemory = c.getDeclaredField("reservedMemory");
        reservedMemory.setAccessible(true);
        Long maxMemoryValue = (Long)maxMemory.get(null);
        Long reservedMemoryValue = (Long)reservedMemory.get(null);

        System.out.println(maxMemoryValue);
        System.out.println(reservedMemoryValue);
    }
}
