package com.blogger.user.web.aop;

import com.blogger.user.aop.SimulateUserNoInteface;
import com.blogger.user.aop.SimulateUserOperateImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.concurrent.locks.Lock;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-03-27 22:26
 * @desc
 * @since 1.8
 */

public class DefaultAutoAopTest {

    @Test
    public void defaultAutoCreateTest() throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/spring/spring-defaultauto.xml");

        // 获取simulateUserNointeface实例
        SimulateUserNoInteface simulateUserNoInteface = (SimulateUserNoInteface)context.getBean("simulateUserNoInteface");

        simulateUserNoInteface.deleteUser("张三");

        simulateUserNoInteface.updateUser("李四");
    }
}
