package com.blogger.user.web.thread;

import java.io.BufferedOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-30 19:58
 * @desc
 * @since 1.8
 */
public class WriteThread implements Runnable {

    private BufferedOutputStream bis;

    private String sign;

    private CountDownLatch countDownLatch;

    public WriteThread(BufferedOutputStream bis, String sign, CountDownLatch countDownLatch) {

        this.bis = bis;
        this.sign = sign;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.writeLock().lock();

        try {

            String aa = sign + "===  ";
            System.out.println(aa);
            bis.write(aa.getBytes("UTF-8"));
            countDownLatch.countDown();
        } catch (Exception e) {

            e.printStackTrace();
        }

        readWriteLock.writeLock().unlock();
    }
}
