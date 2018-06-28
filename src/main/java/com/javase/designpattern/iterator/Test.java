package com.javase.designpattern.iterator;

import com.javase.designpattern.iterator.impl.NameRepository;

/**
 * author: alan.peng
 * description:
 * date: create in 10:02 2018/3/28
 * modified By：
 */
public class Test {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println("name：" + name);
        }
    }
}
