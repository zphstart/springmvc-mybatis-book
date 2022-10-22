package com.zph.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @auther zph
 * @date 2022/9/12 - 20:50
 * 日志切面类
 */
@Aspect
@Component
public class LogInterceptor {

    @Before(value = "execution(String com.zph.controller.UserController.find(Integer))")
    public void before(){
        System.err.println("进入方法时间："+System.currentTimeMillis());
    }

    @After(value = "execution(String com.zph.controller.UserController.find(Integer))")
    public void after(){
        System.err.println("退出方法时间："+System.currentTimeMillis());
    }
}
