package com.blogger.user.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * 类备注：环绕增强器
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 16:45
 * @desc
 * @since 1.8
 */
public class MyAroundAdvice implements MethodInterceptor {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        // 目标传入参数
        Object[] args = invocation.getArguments();

        logger.info("增加事务开始,当前传入的值为" + args[0] + "=====");

        // 目标对象
        Object obj = invocation.proceed();

        logger.info("增加事务结束,当前传入的值为" + args[0] + "=====");

        return obj;
    }
}
