package com.zph.study.singleton;

/**
 * @auther zph
 * @date 2022/9/12 - 11:22
 * 双重检锁(会有指令重排出现的错误)
 */
public class Singleton4 {
    private static Singleton4 singleton = null;

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        if (singleton == null){
            synchronized (Singleton4.class){
                if (singleton == null){     //再次检查，防止第一次判断有多个线程进入导致出现多例情况
                    singleton = new Singleton4();   //非原子操作,JVM会对代码进行指令重排
                }
            }
        }
        return singleton;
    }
}
