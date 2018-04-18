package com.blogger.user.web.http;

import com.blogger.user.web.aop.DefaultAutoAopTest;

import java.net.InetAddress;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-01 23:30
 * @desc
 * @since 1.8
 */

public class MyInetAddress {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("com.blogger.user.web.aop.DefaultAutoAopTest");

        DefaultAutoAopTest a = (DefaultAutoAopTest) c.newInstance();

        System.out.println(a);
    }
}
