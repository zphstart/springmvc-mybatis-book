package com.zph.test;

import org.junit.Test;

import com.zph.study.singleton.Singleton1;
import com.zph.study.singleton.Singleton2;

/**
 * @auther zph
 * @date 2022/9/12 - 11:04
 */
public class SingletonTest extends BaseJunit4Test{


    @Test
    public void Singleton1Test(){
        Singleton1 obj1 = Singleton1.getInstance();
        Singleton1 obj2 = Singleton1.getInstance();
        System.err.println(obj1 == obj2);
    }

    @Test
    public void Singleton2Test(){
        Singleton2 obj1 = Singleton2.getInstance();
        Singleton2 obj2 = Singleton2.getInstance();
        System.err.println(obj1 == obj2);
    }

}
