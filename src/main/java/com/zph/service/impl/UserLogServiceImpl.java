package com.zph.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.dao.UserLogDao;
import com.zph.model.UserLog;
import com.zph.service.UserLogService;

/**
 * @auther zph
 * @date 2022/9/25 - 19:04
 */
@Service
public class UserLogServiceImpl implements UserLogService {

    @Resource
    private UserLogDao userLogDao;
    @Override
    public int save(UserLog userLog) {
        return userLogDao.save(userLog);
    }
}
