package com.zph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther zph
 * @date 2022/9/11 - 10:45
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
}
