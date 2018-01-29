package com.javase.genericity.test2;

/**
 * author: alan.peng
 * description:
 * date: create in 15:36 2018/1/24
 * modified By：
 */
public class Holder1 {

    private Object a;

    public Holder1(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }
    public Object get(){
        return a;
    }

    public static void main(String[] args) {
        Holder1 holder1 = new Holder1("not Generic");
        String s = (String) holder1.get();
        holder1.set(1);
        Integer x = (Integer) holder1.get();
    }
}
