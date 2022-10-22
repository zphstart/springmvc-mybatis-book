package com.zph.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;



/**
 * @auther zph
 * @date 2022/9/11 - 10:07
 */
@Service
public class SpringTest {

    @Test
    public void testSpring(){
        //从类路径下寻找指定的xml配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTest sprintTest =(SpringTest) applicationContext.getBean("springTest");
        sprintTest.sayHello();
    }

    public void sayHello(){
        System.err.println("hello say");
    }
}
