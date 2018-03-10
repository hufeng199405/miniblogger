package com.blogger.user.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

import java.lang.reflect.Method;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 16:45
 * @desc
 * @since 1.8
 */
public class MyBeforAdvice implements MethodBeforeAdvice {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        logger.info("增加事务开始,当前传入的值为" + args[0] + "=====");
    }
}
