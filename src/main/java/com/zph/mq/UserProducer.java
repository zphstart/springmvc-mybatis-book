package com.zph.mq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.zph.model.User;

/**
 * @auther zph
 * @date 2022/10/2 - 9:43
 */
@Component
public class UserProducer {

    @Resource
    private JmsTemplate jmsTemplate;

    private Logger log = Logger.getLogger(this.getClass());

    public void sendMessage(Destination destination, final User user){
        log.info("生产者------》用户名："+user.getUsername() +" 密码："+user.getPassword());
        jmsTemplate.convertAndSend(destination,user);
    }
}
