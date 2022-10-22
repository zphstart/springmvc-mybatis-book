package com.zph.study.singleton;

/**
 * @auther zph
 * @date 2022/9/12 - 11:10
 * 懒汉式
 */
public class Singleton2 {

    private static Singleton2 singleton = null;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if (singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
}
