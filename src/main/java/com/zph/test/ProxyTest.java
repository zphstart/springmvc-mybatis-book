package com.zph.test;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.zph.study.proxy.CatPainter;
import com.zph.study.proxy.DogPainter;
import com.zph.study.proxy.LogProxyPainter;
import com.zph.study.proxy.Painter;
import com.zph.study.proxy.ProxyLogHandler;
import com.zph.study.proxy.TimeProxyHandler;
import com.zph.study.proxy.TimeProxyPainter;

/**
 * @auther zph
 * @date 2022/9/12 - 19:59
 */
public class ProxyTest extends BaseJunit4Test{

    @Test
    public void proxyPainterTest(){
        TimeProxyPainter timeProxyPainter = new TimeProxyPainter(new LogProxyPainter(new DogPainter()));
        timeProxyPainter.paint();
        TimeProxyPainter timeProxyPainter1 = new TimeProxyPainter(new LogProxyPainter(new CatPainter()));
        timeProxyPainter1.paint();
    }


    @Test
    public void proxyPainterTest2(){
        DogPainter dogPainter = new DogPainter();
        Painter painter =(Painter) Proxy.newProxyInstance(
                DogPainter.class.getClassLoader(),
                DogPainter.class.getInterfaces(),
                new TimeProxyHandler(dogPainter)
        );
        painter.paint();
    }

    @Test
    public void proxyPainterTest3(){
        Painter painter = (Painter) Proxy.newProxyInstance(DogPainter.class.getClassLoader(),DogPainter.class.getInterfaces(),new ProxyLogHandler(new DogPainter()));
        painter.paint();
    }
}
