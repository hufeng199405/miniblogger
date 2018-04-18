package com.blogger.user.web.aop;

import com.blogger.user.aop.SimulateUserNoInteface;
import com.blogger.user.aop.SimulateUserOperateImpl;
import com.blogger.user.service.UserService;
import javafx.application.Application;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-12 16:06
 * @desc
 * @since 1.8
 */
@ContextConfiguration("classpath:spring.xml")
public class SpringAopTest extends AbstractTransactionalTestNGSpringContextTests{

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Test
    public void springAoptest() throws Exception {

        userService.updateUserLogin("123", "123");
    }
}
