package com.zph.study.proxy;

/**
 * @auther zph
 * @date 2022/9/12 - 19:54
 */
public class LogProxyPainter implements Painter{

    private Painter painter;

    public LogProxyPainter(Painter painter){
        this.painter = painter;
    }

    @Override
    public void paint() {
        System.err.println("画画记录日志start。。。");
        painter.paint();
        System.err.println("画画记录日志end。。。");
    }
}
