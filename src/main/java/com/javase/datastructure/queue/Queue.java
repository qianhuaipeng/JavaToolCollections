package com.javase.datastructure.queue;


import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * author: alan.peng
 * description: 使用数组实现队列
 * date: create in 15:25 2018/4/25
 * modified By：
 */
public class Queue<Item> implements Iterable<Item> {

    private Item[] q;
    private int N;  //队列中元素的数量
    private int first;  // 队列元素中的下标
    private int last;   // 队尾元素的后一个位置的下标，也就是元素入列时可以放置的位置

    /**
     * 初始化队列，此时头尾下标重合
     */
    public Queue(){
        q = (Item[]) new Object[2];
        N = 0;
        first = 0;
        last = 0;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i< N; i ++) {
            temp[i] = q[(first+1) % q.length];
        }
        q = temp;
        first = 0;
        last = N;
    }

    public void enqueue(Item item) {
        if (N == q.length) {
            resize(2*q.length);
        }
        q[last++] = item;
        if (last == q.length) last = 0;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underFlow");
        Item item = q[first];
        q[first] = null;
        N--;
        first ++;
        if (first == q.length) first=0;
        if (N > 0 && N == q.length/4) resize(q.length/2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underFlow");
        return q[first];
    }

    private class ArrayIterator implements Iterator<Item> {
        private  int i = 0;
        public boolean hasNext() {
            return i < N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        //直接利用first进行遍历，注意可能存在数组的循环利用
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }

    }


    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
