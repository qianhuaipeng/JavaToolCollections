package com.javase.designpattern.proxy.test1;

import com.javase.designpattern.proxy.test1.impl.CountImpl;

/**
 * @author: alan.peng
 * @description:
 * @date: create in 14:35 2018/1/5
 * @modified By：
 */
public class CountProxy  implements Count{

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl){
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("事务处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        countImpl.updateCount();
        System.out.println("事务处理之后");
    }
}
