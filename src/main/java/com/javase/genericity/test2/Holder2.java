package com.javase.genericity.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 15:37 2018/1/24
 * modified By：
 */
public class Holder2<T> {

    private T a;


    public Holder2(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2<String> holder2 = new Holder2<String>("Generic");
        String s = holder2.get();

        holder2.set("test");
        //holder2.set(1); //无法编译   参数 1 不是 String 类型

    }



}
