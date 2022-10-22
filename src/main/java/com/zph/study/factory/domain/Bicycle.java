package com.zph.study.factory.domain;

/**
 * @auther zph
 * @date 2022/9/12 - 11:33
 */
public class Bicycle implements Vehicle{
    @Override
    public void run() {
        System.err.println("自行车.....");
    }
}
