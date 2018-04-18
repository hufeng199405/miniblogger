package com.blogger.user.service.impl;

import com.blogger.user.dao.UserDao;
import com.blogger.user.dao.impl.UserDaoImpl;
import com.blogger.user.domain.User;
import com.blogger.user.service.CacheService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-18 23:26
 * @desc
 * @since 1.8
 */

@Service
public class CacheServiceImpl implements CacheService{

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserDao userDaoImpl;

    @Cacheable(cacheNames = "cacheTest", key = "#user")
    public User getObj(String user) throws Exception {

        logger.info("没命中缓存，使用查询完成!");

        return userDaoImpl.findByUserName(user);
    }
}
