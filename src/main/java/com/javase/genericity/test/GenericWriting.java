package com.javase.genericity.test;

import com.javase.genericity.fruit.Apple;
import com.javase.genericity.fruit.Jonathan;
import com.javase.genericity.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 14:24 2018/1/24
 * modified By：
 */
public class GenericWriting {

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Orange> oranges = new ArrayList<Orange>();
    static List<Jonathan> jonathans = new ArrayList<Jonathan>();

    static <T> void writeExact(List<T> list,T item){
        list.add(item);
    }

    static void f1(){
        writeExact(apples,new Apple());
        writeExact(oranges,new Orange());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }

    static void f2(){
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(apples, new Jonathan());
        writeWithWildcard(oranges, new Orange());
        writeWithWildcard(jonathans, new Jonathan());

    }


    public static void main(String[] args) {
        f1();
        f2();
    }
}
