package com.blogger.user.web.thread.producerandconsumer;

import com.blogger.user.web.thread.ThreadUtils;
import org.testng.annotations.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 类备注：生产者和消费者测试
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-01 10:26
 * @desc
 * @since 1.8
 */

public class ProducerAndConsumerTest {

    public static void main(String[] args) throws Exception {

        // 从线程池中获取线程
        ExecutorService executorService = ThreadUtils.getThreadPool();

        // 定义一个链表队列
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<Integer>(10);



        executorService.submit(new Producer(blockingQueue));
        executorService.submit(new Consumer(blockingQueue));
    }
}
