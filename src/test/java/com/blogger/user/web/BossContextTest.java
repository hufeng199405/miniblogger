package com.blogger.user.web;

import com.blogger.user.domain.Boss;
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

public class BossContextTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void bossTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "spring-application-car.xml");

        /*ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext(new String[]{ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "spring-car1.xml"}, applicationContext);*/

        Boss boss = applicationContext.getBean("boss", Boss.class);

       /* logger.info(boss.getFa().get(0));
        logger.info(boss.getFaArrays()[0]);
        logger.info(boss.getMap().get("xxx"));
        logger.info(boss.getProperties().getProperty("myProp1"));*/
        logger.info("boss中的car bean为 :" + boss.getCar().getColor());
    }
}
