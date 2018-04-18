package com.blogger.user.web.thread.producerandconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * 类备注：消费者线程
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-01 10:23
 * @desc
 * @since 1.8
 */

public class Consumer implements Runnable {

    // 定义一个线程安全的队列
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {

            while (true) {

                System.out.println("系统消费者" + Thread.currentThread().getName() + "消费了一个数据" + blockingQueue.take());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
