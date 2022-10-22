package com.zph.study.singleton;

/**
 * @auther zph
 * @date 2022/9/12 - 11:27
 *
 * volatile禁止指令重排
 */
public class Singleton5 {
    private static volatile Singleton5 singleton = null;

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        if (singleton == null){
            synchronized (Singleton4.class){
                if (singleton == null){     //再次检查，防止第一次判断有多个线程进入导致出现多例情况
                    singleton = new Singleton5();   //非原子操作,JVM会对代码进行指令重排
                }
            }
        }
        return singleton;
    }
}
