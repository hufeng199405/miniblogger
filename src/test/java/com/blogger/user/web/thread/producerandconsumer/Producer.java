package com.blogger.user.web.thread.producerandconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类备注：生产者线程
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-01 10:18
 * @desc
 * @since 1.8
 */

public class Producer implements Runnable {

    // 定义一个线程安全的队列
    private BlockingQueue<Integer> blockingQueue;

    Lock lock = new ReentrantLock();

    public Producer(BlockingQueue<Integer> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        lock.lock();

        try {

            // 循环放入数据
            for (int i = 0; i < 100; i++) {

                if (i % 2 == 0) {

                    blockingQueue.put(i);

                    System.out.println("系统生产者" + Thread.currentThread().getName() + "生产了一个数据" + i);

                    Thread.sleep(200);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            if (lock != null) {

                lock.unlock();
            }
        }
    }
}
