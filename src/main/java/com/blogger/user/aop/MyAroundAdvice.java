package com.blogger.user.aop;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

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
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
