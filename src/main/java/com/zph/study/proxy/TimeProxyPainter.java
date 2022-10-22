package com.zph.study.proxy;

import java.time.LocalDate;

/**
 * @auther zph
 * @date 2022/9/12 - 20:10
 */
public class TimeProxyPainter implements Painter{

    private Painter painter;

    public TimeProxyPainter(Painter painter){
        this.painter = painter;
    }
    @Override
    public void paint() {
        System.err.println(LocalDate.now());
        painter.paint();
        System.err.println(LocalDate.now());
    }
}
