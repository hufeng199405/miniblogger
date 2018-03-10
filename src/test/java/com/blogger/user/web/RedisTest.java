package com.blogger.user.web;

import com.blogger.user.springtest.RedisService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-02 17:51
 * @desc
 * @since 1.8
 */
public class RedisTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void bossTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "spring/spring-redis.xml");

        RedisService redisService = applicationContext.getBean("redisService", RedisService.class);

        //redisService.getHashOperations().put("test","mykey","myValue2");

        redisService.getHashOperations().delete("test", "mykey");

        logger.info(redisService.getHashOperations().get("test", "mykey"));
    }
}
