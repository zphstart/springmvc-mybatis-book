package com.zph.mq;


import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import com.zph.model.User;

/**
 * @auther zph
 * @date 2022/10/2 - 9:50
 */
@Component
public class UserConsumer implements MessageListener {

    private static int count =0;

    @Resource
    private RedisTemplate redisTemplate;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void onMessage(Message message) {
        try {
            //从message对象中获取user实体
            User user = (User)((ActiveMQObjectMessage)message).getObject();
            System.out.println(user);
            //存放到redis中
            redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
            redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
            redisTemplate.setHashValueSerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
            redisTemplate.opsForHash().put("user"+count,"username",user.getUsername());
            redisTemplate.opsForHash().put("user"+count,"password",user.getPassword());

            //记录日志
            log.info("消费者-----》用户名："+user.getUsername()+"密码："+user.getPassword());
            count++;
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
}
