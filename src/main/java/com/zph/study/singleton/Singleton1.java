package com.zph.study.singleton;

import org.springframework.stereotype.Component;

/**
 * @auther zph
 * @date 2022/9/12 - 11:02
 * 饿汉单例
 */
@Component
public class Singleton1 {

    private static final Singleton1 singleton = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        return singleton;
    }
}
