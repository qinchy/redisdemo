package com.qinchy.redisdemoapi.service.impl;

import com.qinchy.redisdemoapi.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    private Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(String key, String value) {
        boolean flag = false;
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            flag = true;
        } catch (Exception e) {
            log.error("设置值失败", e);
        }
        return flag;
    }

    @Override
    public String get(String key) {
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
        return String.valueOf(operations.get(key));
    }
}
