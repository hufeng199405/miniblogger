package com.blogger.user.web;

import com.blogger.user.domain.Boss;
import com.blogger.user.springtest.MagicBoss;
import com.blogger.user.springtest.MagicBossService;
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
 * @date 2018-02-06 21:32
 * @desc
 * @since 1.8
 */

public class MagicBossContextTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void bossTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "spring-magicBoss.xml");

        /*MagicBoss boss = applicationContext.getBean("magicBoss", MagicBoss.class);

        logger.info(boss.getCar().getName());*/

        MagicBossService magicBossService = applicationContext.getBean("magicBossService", MagicBossService.class);

        logger.info(magicBossService.getCar());
    }
}
