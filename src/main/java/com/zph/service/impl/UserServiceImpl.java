package com.zph.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zph.dao.UserDao;
import com.zph.model.User;
import com.zph.mq.UserProducer;
import com.zph.service.UserService;

/**
 * @auther zph
 * @date 2022/9/11 - 15:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserProducer userProducer;

    //队列
    private static Destination destination = new ActiveMQQueue("ay.queue.high.concurrency.praise");

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public void save(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void update(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void saveRedis(int num , User user) {

        //发送消息
        userProducer.sendMessage(destination,user);
//        redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
//        redisTemplate.opsForHash().put("user"+num,"username",user.getUsername());
//        redisTemplate.opsForHash().put("user"+num,"password",user.getPassword());
    }
}
