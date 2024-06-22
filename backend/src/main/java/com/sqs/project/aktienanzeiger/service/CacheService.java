package com.sqs.project.aktienanzeiger.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private RedisTemplate<String, String> redisTemplate;

    public CacheService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void saveToCache(String key, String data, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, data, timeout, unit);
    }
    public void deleteFromCache(String key) {
        redisTemplate.delete(key);
    }
}
