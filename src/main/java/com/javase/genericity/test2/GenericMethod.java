package com.javase.genericity.test2;


/**
 * author: alan.peng
 * description:
 * date: create in 15:44 2018/1/24
 * modified By：
 */
public class GenericMethod {

    public <K,V> void f(K k , V v){
        System.out.println(k.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public <A,B> void f1(A a, B b){
        System.out.println(a.getClass().getSimpleName());
        System.out.println(b.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.f(new Integer(0), new java.lang.String("nihao"));
        genericMethod.f1(new Integer(0), new java.lang.String("nihao"));

    }
}
