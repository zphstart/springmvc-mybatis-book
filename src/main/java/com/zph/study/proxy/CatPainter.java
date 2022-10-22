package com.zph.study.proxy;

/**
 * @auther zph
 * @date 2022/9/12 - 19:53
 */
public class CatPainter implements Painter {
    @Override
    public void paint() {
        System.err.println("小猫画画");
    }
}
