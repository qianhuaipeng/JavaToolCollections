package com.jvm.gc;

/**
 * author: alan.peng
 * description:
 * date: create in 17:41 2018/1/5
 * modified By：
 */
public class ReferenceCountingGc {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGc(){
        ReferenceCountingGc objA  = new ReferenceCountingGc();
        ReferenceCountingGc objB  = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("excuted finalize method...");
    }

    public static void main(String[] args) {
        testGc();
    }
}
