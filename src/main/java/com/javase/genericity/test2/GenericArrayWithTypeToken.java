package com.javase.genericity.test2;

import java.lang.reflect.Array;

/**
 * author: alan.peng
 * description: 创建泛型数组
 * date: create in 18:56 2018/1/24
 * modified By：
 */
public class GenericArrayWithTypeToken<T> {


    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int size){
        array = (T[]) Array.newInstance(type,size);
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken = new GenericArrayWithTypeToken<>(Integer.class,10);
        System.out.println(genericArrayWithTypeToken.rep());
    }
}
