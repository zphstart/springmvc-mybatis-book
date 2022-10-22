package com.zph.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zph
 * @date 2022/9/12 - 20:24x
 */
public class TimeProxyHandler implements InvocationHandler {

    private Painter painter;

    public TimeProxyHandler(Painter painter){
        this.painter = painter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = method.invoke(painter, args);
        long end = System.currentTimeMillis();
        System.err.println("执行了"+(end-start)+"毫秒");
        return o;
    }
}
