package com.spring.aop;

import com.spring.aop.service.IHelloService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author: alan.peng
 * description:
 * date: create in 10:54 2018/1/29
 * modified By：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-aop.xml" })
public class HelloAopTest extends TestCase {

    @Autowired
    private IHelloService helloService;

    @Test
    public void test(){
        helloService.sayHello();
    }
}
