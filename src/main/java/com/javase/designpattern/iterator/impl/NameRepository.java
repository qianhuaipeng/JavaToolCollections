package com.javase.designpattern.iterator.impl;

import com.javase.designpattern.iterator.Container;
import com.javase.designpattern.iterator.Iterator;

/**
 * author: alan.peng
 * description:
 * date: create in 9:59 2018/3/28
 * modified By：
 */
public class NameRepository implements Container {

    String names[] = {"alan","james","wade","paul","kobe"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;
        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext())  {
                return names[index++];
            }
            return null;
        }
    }
}
