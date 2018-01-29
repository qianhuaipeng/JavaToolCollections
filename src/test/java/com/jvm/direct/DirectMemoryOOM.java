package com.jvm.direct;

import java.nio.ByteBuffer;

/**
 * author: alan.peng
 * description:
 * date: create in 16:15 2018/1/8
 * modified By：
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){
        ByteBuffer.allocateDirect(10*_1MB);
        ByteBuffer.allocateDirect(_1MB);
    }
}
