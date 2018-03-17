package com.blogger.user.web.aop;

import com.blogger.user.aop.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.testng.annotations.Test;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 17:24
 * @desc
 * @since 1.8
 */
public class AopTest {

    /*@Test
    public void aoptestImpl() throws Exception {

        SimulateUserOperate simulateUserOperate = new SimulateUserOperateImpl();

        // 前置增强
        MyBeforAdvice myBeforAdvice = new MyBeforAdvice();

        // 后置增强
        MyAfterAdvice myAfterAdvice = new MyAfterAdvice();

        ProxyFactory factory = new ProxyFactory();

        // 给需要代理的类创建代理类
        factory.setTarget(simulateUserOperate);

        factory.setOptimize(true);

        // 增加增强
        factory.addAdvice(myBeforAdvice);
        factory.addAdvice(myAfterAdvice);

        simulateUserOperate = (SimulateUserOperate) factory.getProxy();

        simulateUserOperate.deleteUser("test");
    }*/

    @Test
    public void intestImpl() throws Exception {

        SimulateUserOperate simulateUserOperate = new SimulateUserOperateImpl();

        // 环绕增强
        MethodInterceptor methodInterceptor = new MyAroundAdvice();

        ProxyFactory factory = new ProxyFactory();

        // 给需要代理的类创建代理类
        factory.setTarget(simulateUserOperate);

        factory.setOptimize(true);

        // 增加增强
        factory.addAdvice(methodInterceptor);

        simulateUserOperate = (SimulateUserOperate) factory.getProxy();

        simulateUserOperate.deleteUser("test");
    }

    @Test
    public void startXmlTest() throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/spring-around-aop.xml");

        SimulateUserOperate simulateUserOperate = applicationContext.getBean("simulateTarge", SimulateUserOperate.class);

        SimulateUserNoInteface inteface = applicationContext.getBean("simulateTargeNoInteface", SimulateUserNoInteface.class);

        simulateUserOperate.deleteUser("xxxx");

        inteface.deleteUser("yyyy");
    }
}
