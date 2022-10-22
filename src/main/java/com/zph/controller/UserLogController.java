package com.zph.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zph.model.UserLog;
import com.zph.service.UserLogService;

/**
 * @auther zph
 * @date 2022/9/25 - 19:06
 */
@Controller
public class UserLogController {
    @Resource
    private UserLogService userLogService;

    @Transactional(propagation = Propagation.NESTED)
    public int save(UserLog  userLog){
        int result = userLogService.save(userLog);
        return result;
    }
}
