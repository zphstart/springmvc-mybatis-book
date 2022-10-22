package com.zph.test;

import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @auther zph
 * @date 2022/10/1 - 17:55
 */
public class RedisTest  extends BaseJunit4Test{

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        redisTemplate.opsForValue().set("name","ay");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("value: "+name);
    }
}
