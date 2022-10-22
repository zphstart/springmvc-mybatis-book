package com.zph.study.proxy;

import java.time.LocalDate;

/**
 * @auther zph
 * @date 2022/9/13 - 20:26
 */
public class MyLogImpl implements ProxyLog{
    @Override
    public void start() {
        System.err.println("进入方法时间"+ LocalDate.now());
    }

    @Override
    public void end() {
        System.err.println("推出方法时间："+LocalDate.now());
    }
}
