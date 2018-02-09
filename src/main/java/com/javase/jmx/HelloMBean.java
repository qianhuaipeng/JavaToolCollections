package com.javase.jmx;

/**
 * author: alan.peng
 * description:
 * date: create in 11:25 2018/2/9
 * modified By：
 */
public interface HelloMBean {

    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();
}
