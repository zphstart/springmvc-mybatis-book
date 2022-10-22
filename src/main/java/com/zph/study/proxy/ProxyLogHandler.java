package com.zph.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zph
 * @date 2022/9/13 - 20:28
 */
public class ProxyLogHandler implements InvocationHandler {

    private Painter painter;

    private ProxyLog proxyLog = new MyLogImpl();

    public ProxyLogHandler(Painter painter){
        this.painter = painter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        proxyLog.start();
        Object result = method.invoke(painter, args);
        proxyLog.end();
        return result;
    }
}
