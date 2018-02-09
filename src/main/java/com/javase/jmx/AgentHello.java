package com.javase.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * author: alan.peng
 * description:
 * date: create in 11:28 2018/2/9
 * modified By：
 */
public class AgentHello {

    public static void main(String[] args) throws Exception{
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60*60*1000);
    }
}
