package com.blogger.user.web.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-30 17:02
 * @desc
 * @since 1.8
 */
public class ThreadUtils {

    private static ExecutorService executorService;

    public static ExecutorService getThreadPool() throws Exception {

        if (executorService == null) {

            executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        }

        return executorService;
    }
}
