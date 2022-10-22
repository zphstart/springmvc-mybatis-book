package com.zph.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zph.model.User;
import com.zph.model.UserLog;
import com.zph.service.UserService;
import com.zph.validation.UserValidator;

/**
 * @auther zph
 * @date 2022/9/11 - 15:22
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserLogController userLogController;

    @Resource
    private UserService userService;

    @Resource
    private UserValidator userValidator;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println("id: "+user.getId());
            System.out.println("username: "+user.getUsername());
        }
        model.addAttribute("user","张三");
        return "hello";
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public String find(@RequestParam("userId") Integer id){
        User user = userService.findOne(id);
        return "hello";
    }

//    @Transactional()
    @PostMapping ("/save")
    public String save(@RequestBody User user, Model model, Errors errors) throws InterruptedException {
        userValidator.validate(user,errors);
        if (errors.hasErrors()){
            model.addAttribute("errors",errors);
            return "error";
        }
        userService.save(user);
        Thread.sleep(20000);
        UserLog userLog = new UserLog();
        try {
            BeanUtils.copyProperties(userLog,user);
            userLog.setDate(new Date());
        } catch (Exception e) {
            System.err.println("对象复制失败");
        }
        userLogController.save(userLog);
        return "success";
    }

    @ModelAttribute
    public void init(){
        System.err.println("初始化UserController========");
    }

    @ModelAttribute
    public void init1(Model model){
        model.addAttribute("init","UserController已经初始化");
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(Model model){
        String init =(String) model.getAttribute("init");
        return init + "-----------hello";
    }

    @PostMapping("/update")
    @Transactional(propagation = Propagation.REQUIRED)
    public String update(@RequestBody User user,Model model,Errors errors) throws InterruptedException {
        System.err.println(user);
        if (user!=null){
            User one = userService.findOne(user.getId());
            if (one.getId()!=null){
                userService.update(user);
            }else{
                save(user,model,errors);
            }
        }
        return "success";
    }

    @GetMapping("/saveUser")
    public String saveUser(){
        int count = 0;
        ArrayList<String> userList = new ArrayList<>();
        userList.add("zhangsan");
        userList.add("lisi");
        userList.add("wangwu");
        userList.add("zhaosi");
        userList.add("liuneng");
        userList.add("xieguangkun");
        userList.add("xiefeiji");
        ArrayList<String> passwordList = new ArrayList<>();
        passwordList.add("1111111");
        passwordList.add("22222");
        passwordList.add("33333");
        passwordList.add("5555555");
        passwordList.add("6666666");
        Random random = new Random();
        while (count<5){
            int userIndex = random.nextInt(userList.size());
            int passwordIndex = random.nextInt(passwordList.size());
            User user = new User();
            user.setUsername(userList.get(userIndex));
            user.setPassword(passwordList.get(passwordIndex));
            userService.saveRedis(count,user);
            count++;
        }
        return "success";
    }
}
