package com.blogger.user.springtest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-02 17:45
 * @desc
 * @since 1.8
 */
@Service
public class RedisService {

    /*@Resource(name = "redisTemplate")
    private HashOperations hashOperations;

    public HashOperations getHashOperations() {
        return hashOperations;
    }

    public void setHashOperations(HashOperations hashOperations) {
        this.hashOperations = hashOperations;
    }*/
}
