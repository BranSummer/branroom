package org.bran.branroom.config;

import org.springframework.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache implements Cache {

    private RedisTemplate<String,Object> redisTemplate;

    private String name;

    public RedisTemplate<String,Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 本地缓存
     * @return
     */
    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object o) {
        return null;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public void put(Object o, Object o1) {

    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object o) {

    }

    @Override
    public void clear() {

    }
}
