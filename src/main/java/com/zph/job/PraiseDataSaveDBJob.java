package com.zph.job;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zph.model.User;
import com.zph.service.UserService;

/**
 * @auther zph
 * @date 2022/10/1 - 18:33
 */
@Component
@Configuration
@EnableScheduling
public class PraiseDataSaveDBJob {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserService userService;

    @Scheduled(cron="*/20 * * * * *")
    private void savePraiseDataToDB2(){
        String entry = "user";
        int count = redisTemplate.keys("*").size();
        for (int i = 0; i < count; i++) {
            Map map = redisTemplate.opsForHash().entries(entry + i);
            String username =(String) map.get("username");
            String password =(String) map.get("password");
            System.out.println(entry + " "+username+" "+password );
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            System.out.println(user);
            userService.save(user);
            redisTemplate.delete(entry+i);
        }
    }
}
