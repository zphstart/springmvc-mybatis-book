package com.zph.study.singleton;

/**
 * @auther zph
 * @date 2022/9/12 - 11:20
 * 懒汉多线程安全
 */
public class Singleton3 {
    private static Singleton3 singleton3 = null;

    private Singleton3(){}

    public static synchronized Singleton3 getInstance(){
        if (singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
