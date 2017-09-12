package com.qinchy.redisdemoapi.service;

import org.springframework.stereotype.Component;

@Component
public interface RedisService {
    boolean set(String key, String value);

    String get(String key);
}
