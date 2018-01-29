package com.javase.genericity.test1;

/**
 * author: alan.peng
 * description:
 * date: create in 14:53 2018/1/24
 * modified By：
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData(){
        return data;
    }
    }
