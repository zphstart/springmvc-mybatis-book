package com.zph.study.proxy;

/**
 * @auther zph
 * @date 2022/9/12 - 19:52
 */
public class DogPainter implements Painter{
    @Override
    public void paint() {
        System.err.println("小狗画画");
    }
}
