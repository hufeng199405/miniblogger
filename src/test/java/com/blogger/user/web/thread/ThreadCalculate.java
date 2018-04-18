package com.blogger.user.web.thread;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.channels.Channel;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-30 16:28
 * @desc
 * @since 1.8
 */
public class ThreadCalculate {

    @Test
    public void forTest() throws Exception {

        FutureTask task = new FutureTask(() -> {
            return "suceess";
        });

        new Thread(task).start();

        System.out.println(task.get());
    }

    @Test
    public void test() throws Exception {

        // 创建一个文件
        File file = new File("d://xx//xxx.txt");

        if (!file.exists()) {

            //file.mkdirs();
        }

        FileOutputStream im = null;

        im = new FileOutputStream(file);

        BufferedOutputStream bis = new BufferedOutputStream(im);

        // 获取file的channel
        //Channel channel = im.getChannel();

        // 获取线程池对象
        ExecutorService service = ThreadUtils.getThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    try {
                        String aa = Thread.currentThread().getName();
                        System.out.println(aa);
                        bis.write(aa.getBytes("UTF-8"));
                        countDownLatch.countDown();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            };

            service.submit(runnable);
        }

        countDownLatch.await();

        System.out.println(111);

        bis.flush();
        im.flush();
    }

    @Test
    public void test1() throws Exception {

        // 创建一个文件
        File file = new File("d://xx//xxx.txt");

        if (!file.exists()) {

            //file.mkdirs();
        }

        FileOutputStream im = null;

        im = new FileOutputStream(file);

        BufferedOutputStream bis = new BufferedOutputStream(im);

        // 获取file的channel
        //Channel channel = im.getChannel();

        // 获取线程池对象
        ExecutorService service = ThreadUtils.getThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {

            WriteThread writeThread = new WriteThread(bis, "test" + i, countDownLatch);

            Future future = service.submit(writeThread);

            // 中断还是运行结束？true代表中断
            //future.cancel(true);
        }

        countDownLatch.await();

        bis.flush();
        im.flush();

        bis.close();
        im.close();

    }
}
