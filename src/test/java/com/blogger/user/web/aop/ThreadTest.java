package com.blogger.user.web.aop;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-03-28 21:28
 * @desc
 * @since 1.8
 */

public class ThreadTest {

    public volatile AtomicInteger inc = new AtomicInteger(1);

    public void increase() {
        inc.set(inc.get() + 1);
    }

    public static void main(String[] args) {

        final ThreadTest test = new ThreadTest();
        for (int i = 0; i < 10; i++) {

            new Thread() {

                public void run() {

                    for (int j = 0; j < 1000; j++) {

                        test.increase();
                    }
                }
            }.start();
        }

        System.out.println(Thread.activeCount());

       /* while (Thread.activeCount() > 1) {

            //保证前面的线程都执行完
            Thread.yield();
        }*/

        System.out.println(test.inc);
    }
}
