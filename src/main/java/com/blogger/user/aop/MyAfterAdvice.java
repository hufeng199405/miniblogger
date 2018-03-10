package com.blogger.user.aop;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

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
public class MyAfterAdvice implements AfterReturningAdvice {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        logger.info("增加事务结束,当前传入的值为" + args[0] + "=====");
    }
}
