package com.javase.genericity.test2;

import java.util.ArrayList;

/**
 * author: alan.peng
 * description:
 * date: create in 15:52 2018/1/24
 * modified By：
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());
        System.out.println(c1 == c2);

    }
}
