package com.javase.designpattern.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: alan.peng
 * description:
 * date: create in 14:58 2018/1/5
 * modified By：
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;
    public Object bind(Object target){
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);//要绑定这个接口（这是一个缺陷，cglib弥补了这个缺陷）
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事物开始。。。");
        result = method.invoke(target, args);
        System.out.println("事物结束。。。。");
        return result;
    }
}
