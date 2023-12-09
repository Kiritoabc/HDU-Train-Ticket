package com.hdu.train.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author 菠萝
 * @version 1.0
 * @description: Redis存储实体
 * @date 2023/12/9 22:05
 */
@Repository
public class RedisObjUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @description: 存实体类
     * @param: key
     * @return: void
     * @author 菠萝
     * @date: 2023/12/9 22:19
     */
    public void setEntity(String key, Object o) {
        redisTemplate.opsForValue().set(key, o);
    }

    /**
     * @description:  存实体类
     * @param: key
     * @return: void
     * @author 菠萝
     * @date: 2023/12/9 22:19
     */
    public void setEntity(String key,Object o,long time) {
        redisTemplate.opsForValue().set(key, o, time, TimeUnit.MINUTES);
    }


    /**
     * @description:  获取实体类对象
     * @param: key
     * @return: T
     * @author 菠萝
     * @date: 2023/12/9 22:19
     */
    public <T> T getEntity(String key, Class<T> entity) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * @description: 删除缓存
     * @param: key
     * @return: boolean
     * @author 菠萝
     * @date: 2023/12/9 22:18
     */
    public boolean deleteEntity(String key) {
        return redisTemplate.delete(key);
    }
}
