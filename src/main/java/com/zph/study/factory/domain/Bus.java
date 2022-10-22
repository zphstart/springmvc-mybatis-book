package com.zph.study.factory.domain;

/**
 * @auther zph
 * @date 2022/9/12 - 11:32
 */
public class Bus implements Vehicle{
    @Override
    public void run() {
        System.err.println("公交车......");
    }
}
