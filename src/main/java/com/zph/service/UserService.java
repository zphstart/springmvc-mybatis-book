package com.zph.service;

import java.util.List;

import com.zph.model.User;

/**
 * @auther zph
 * @date 2022/9/11 - 15:18
 */
public interface UserService {
    List<User> findAll();

    User findOne(Integer id);

    void save(User user);

    void update(User user);

    void saveRedis(int num,User user);
}
